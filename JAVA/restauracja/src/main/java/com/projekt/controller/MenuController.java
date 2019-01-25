package com.projekt.controller;

import com.projekt.dto.Danie;
import com.projekt.service.DanieService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Named
@ViewScoped
public class MenuController {

    private final DanieService danieService;

    @Getter
    @Setter
    private Danie noweDanie;

    @Getter
    @Setter
    private boolean edycja = false;

    @Getter
    private List<Danie> dania;

    @Inject
    public MenuController(DanieService danieService) {
        this.danieService = danieService;
        noweDanie = Danie.builder().build();
        refresh();
    }

    private void refresh() {
        dania = danieService.pobierzWszystkieDania();
    }

    public String formatPrice(BigDecimal value) {

        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2);

        df.setMinimumFractionDigits(0);

        df.setGroupingUsed(false);

        return df.format(value);
    }

    public void dodajDanie() {

        if (!edycja) {
            danieService.dodajDanie(noweDanie);
        }
        noweDanie = Danie.builder().build();
        edycja = false;
        refresh();
    }

    public void usunDanie(Danie danie) {
        danieService.usunDanie(danie);
        refresh();
    }

    public void edytujDanie(Danie danie) {
        noweDanie = danie;
        edycja = true;
    }

    public void anulujEdycje() {
        noweDanie = Danie.builder().build();
        edycja = false;
    }
}
