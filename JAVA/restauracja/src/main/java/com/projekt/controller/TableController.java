package com.projekt.controller;

import com.projekt.dto.*;
import com.projekt.dto.Dinner;
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
    private Table stol = Table.builder().build();

    @Getter
    @Setter
    private Dinner dinner;

    @Getter
    @Setter
    private String rabatNazwa;

    public void refresh() {
        stol = tableService.getById(id);
    }

    public void dodajDoRachunku(Dinner dinner) {
        stol.getOrder().dodajDanie(dinner);
    }

    public void usunZRachunku(DinnerWrapper danie) {
        stol.getOrder().getDania().removeIf(d -> d.equals(danie));
    }

    public void usunJeden(DinnerWrapper danie) {
        danie.setCount(danie.getCount() - 1);
        if (danie.getCount() < 1) {
            usunZRachunku(danie);
        }
    }

    public void otworzRachunek() {
        stol.setOrder(Order.builder().build());
    }

    public void oplac() {
        Order zamownie = stol.getOrder();
        zamownie.setPaid(true);
        BigDecimal wartoscZamowienia = zamownie
                .getDania()
                .stream()
                .map(DinnerWrapper::getTotalGrossPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        zamownie.setGrossPrice(wartoscZamowienia);
    }

    public void zamknij() {
        Order zamownie = stol.getOrder();
        zamownie.setClose(true);
        if (zamownie.getGrossPrice().compareTo(BigDecimal.ZERO) != 0) {
            this.historyService.add(History.builder().table(stol).order(stol.getOrder()).build());
        }
    }

    public void dodajRabat() {
        Optional<Discount> rabat = discountService.getAll()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(rabatNazwa))
                .findAny();
        if (!rabat.isPresent()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Podany discount nie istnieje");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }
        stol.getOrder().setDiscount(rabat.get());
    }

    public void usunRabat() {
        Optional<Discount> rabat = discountService.getAll()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(rabatNazwa))
                .findAny();
        if (!rabat.isPresent()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Podany discount nie istnieje");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }
        stol.getOrder().setDiscount(Discount.EMPTY);
        rabatNazwa = null;
    }
}
