package com.projekt.controller;

import com.projekt.dto.Discount;
import com.projekt.service.DiscountService;
import com.projekt.util.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import java.util.List;
import java.math.BigDecimal;

@Controller
@Scope("view")
public class DiscountController {

    private final DiscountService discountService;

    @Getter
    private List<Discount> discounts;

    @Getter
    @Setter
    private Discount discount;

    @Getter
    @Setter
    private boolean edit = false;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;

        discount = new Discount();
        refresh();
    }

    private void refresh() {
        discounts = discountService.getAll();
    }

    public void add() {

        if (discount.isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc",
                    "Mozesz wybrac znizke procentowa lub kwotowa");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }

        discountService.add(discount);

        discount = new Discount();
        edit = false;

        refresh();
    }

    public String formatPrice(BigDecimal value) {
        return DecimalFormatter.formatOrEmpty(value);
    }

    public void remove(Discount rabat) {
        this.discountService.remove(rabat);
        refresh();
    }

    public void editDiscount(Discount rabat) {
        discount = rabat;
        edit = true;
    }

    public void abortEdit() {
        discount = new Discount();
        edit = false;
    }
}