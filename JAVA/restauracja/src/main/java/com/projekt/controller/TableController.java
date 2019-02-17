package com.projekt.controller;

import com.projekt.dto.*;
import com.projekt.service.DiscountService;
import com.projekt.service.HistoryService;
import com.projekt.service.TableService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import java.math.BigDecimal;
import java.util.Optional;

@Controller
@Scope("view")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;
    private final DiscountService discountService;
    private final HistoryService historyService;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Table table = new Table();

    @Getter
    @Setter
    private Dinner dinner;

    @Getter
    @Setter
    private String discountName;

    public void refresh() {
        if (id != null) {
            table = tableService.getById(id);
        }
    }

    public void addToOrder(Dinner dinner) {
        table.getOrder().addDinner(dinner);
        tableService.add(table);
    }

    public void removeFromOrder(DinnerWrapper danie) {
        table.getOrder().getDinners().removeIf(d -> d.equals(danie));
        tableService.add(table);
    }

    public void removeOneFromOrder(DinnerWrapper danie) {
        danie.setCount(danie.getCount() - 1);
        if (danie.getCount() < 1) {
            removeFromOrder(danie);
        }
        tableService.add(table);
    }

    public void openNewOrder() {
        table.setOrder(new Order());
    }

    public void pays() {
        Order order = table.getOrder();
        order.setPaid(true);
        BigDecimal orderAmount = order
                .getDinners()
                .stream()
                .map(DinnerWrapper::getTotalGrossPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        order.setGrossPrice(orderAmount);

        tableService.add(table);
    }

    public void closeOrder() {
        Order order = table.getOrder();
        order.setClose(true);
        if (order.getGrossPrice().compareTo(BigDecimal.ZERO) != 0) {
            this.historyService.add(new History(order, table));
        }

        tableService.add(table);
        discountName = null;
    }

    public void addDiscount() {
        Optional<Discount> discount = discountService.findDiscount(discountName);
        if (discount.isPresent()) {
            table.getOrder().setDiscount(discount.get());
            tableService.add(table);
            return;
        }

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Podany rabat nie istnieje");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public void removeDiscount() {
        table.getOrder().setDiscount(Discount.EMPTY);
        discountName = null;
        tableService.add(table);
    }

    public boolean isNewDiscount() {
        return table.getOrder().getDiscount() == null || table.getOrder().getDiscount().isEmpty();
    }
}
