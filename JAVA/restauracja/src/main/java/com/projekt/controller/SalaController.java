package com.projekt.controller;

import com.projekt.dto.Rachunek;
import com.projekt.dto.Stol;
import com.projekt.service.StolService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class SalaController {

    private final StolService stolService;

    @Getter
    @Setter
    private List<Stol> stoly;

    @Inject
    public SalaController(StolService stolService) {
        this.stolService = stolService;
        refresh();
    }

    private void refresh() {
        stoly = stolService.pobierzWszystkieStoly();
    }

    public String zamknietyClass(Rachunek rachunek) {
        return rachunek.isZamkniety() ? ", zamkniety" : "";
    }

    public String oplaconyClass(Rachunek rachunek) {
        return rachunek.isOplacony() ? ", oplacony" : "";
    }

    public String nowyClass(Rachunek rachunek) {
        return !rachunek.isOplacony() && !rachunek.isZamkniety() ? ", nowy" : "";
    }
}