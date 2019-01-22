package com.projekt.controller;


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
public class HistoryController {

    private final StolService stolService;

    @Getter
    @Setter
    private List<Stol> history;

    @Inject
    public HistoryController(StolService stolService) {
        this.stolService = stolService;
        refresh();
    }

    public void refresh(){history = stolService.pobierzHistorie();}
}
