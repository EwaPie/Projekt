package com.projekt.controller;

import com.projekt.dto.Dinner;
import com.projekt.service.DinnerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Controller
@Scope("view")
public class MenuController {

    private final DinnerService dinnerService;
    private final DecimalFormat df;

    @Getter
    @Setter
    private Dinner newDinner;

    @Getter
    @Setter
    private boolean edycja = false;

    @Getter
    private List<Dinner> dania;

    public MenuController(DinnerService danieService) {
        this.dinnerService = danieService;

        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        newDinner = Dinner.builder().build();
        refresh();
    }

    private void refresh() {
        dania = dinnerService.getAll();
    }

    public String formatPrice(BigDecimal price) {
        return df.format(price);
    }

    public void addDinner() {

        if (!edycja) {
            dinnerService.add(newDinner);
        }
        newDinner = Dinner.builder().build();
        edycja = false;
        refresh();
    }

    public void removeDinner(Dinner dinner) {
        dinnerService.remove(dinner);
        refresh();
    }

    public void edytujDanie(Dinner dinner) {
        newDinner = dinner;
        edycja = true;
    }

    public void anulujEdycje() {
        newDinner = Dinner.builder().build();
        edycja = false;
    }
}
