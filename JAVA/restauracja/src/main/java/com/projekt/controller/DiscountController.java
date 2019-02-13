package com.projekt.controller;

import com.projekt.dto.Discount;
import com.projekt.service.DiscountService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import java.util.List;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Controller
@Scope("view")
public class DiscountController {

    private final DiscountService discountService;
    private final DecimalFormat df;

    @Getter
    private List<Discount> discounts;

    @Getter
    @Setter
    private Discount nowyRabat;

    @Getter
    @Setter
    private boolean edycja = false;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;

        df = new DecimalFormat();

        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        nowyRabat = new Discount();
        refresh();
    }

    private void refresh() {
        discounts = discountService.getAll();
    }

    public void dodajRabat() {

        if (nowyRabat.isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Mozesz wybrac znizke procentowa lub kwotowa");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }

        if (!edycja) {
            discountService.add(nowyRabat);

        }
        nowyRabat = new Discount();
        edycja = false;

        refresh();
    }

    public String formatPrice(BigDecimal value) {
        return df.format(value);
    }

    public void usunRabat(Discount rabat) {
        this.discountService.remove(rabat);
        refresh();
    }

    public void edytujRabat(Discount rabat) {
        nowyRabat = rabat;
        edycja = true;
    }

    public void anulujEdycje() {
        nowyRabat = new Discount();
        edycja = false;
    }
}