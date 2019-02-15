package com.projekt.controller;

import com.projekt.dto.Dinner;
import com.projekt.service.DinnerService;
import com.projekt.util.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Scope("view")
public class MenuController {

    private final DinnerService dinnerService;

    @Getter
    @Setter
    private Dinner newDinner;

    @Getter
    @Setter
    private boolean edit = false;

    @Getter
    private List<Dinner> dinner;

    public MenuController(DinnerService danieService) {
        this.dinnerService = danieService;

        newDinner = Dinner.builder().build();
        refresh();
    }

    private void refresh() {
        dinner = dinnerService.getAll();
    }

    public String formatPrice(BigDecimal price) {
        return DecimalFormatter.format(price);
    }

    public void add() {
        dinnerService.add(newDinner);

        newDinner = Dinner.builder().build();
        edit = false;
        refresh();
    }

    public void remove(Dinner dinner) {
        dinnerService.remove(dinner);
        refresh();
    }

    public void editDinner(Dinner dinner) {
        newDinner = dinner;
        edit = true;
    }

    public void abort() {
        newDinner = Dinner.builder().build();
        edit = false;
    }
}
