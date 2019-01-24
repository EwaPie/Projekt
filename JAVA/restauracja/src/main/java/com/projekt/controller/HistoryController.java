package com.projekt.controller;


import com.projekt.dto.Historia;
import com.projekt.dto.Stol;
import com.projekt.service.HistoriaService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class HistoryController {

    private final HistoriaService historiaService;


    @Getter
    @Setter
    private List<Historia> history;

    @Getter
    @Setter
    private List<Historia> pofiltrowanaHistoria;
    @Getter
    @Setter
    private Stol stol = null;

    @Inject
    public HistoryController(HistoriaService historiaService) {
        this.historiaService = historiaService;
        refresh();
    }

    public void refresh(){
        if(stol == null)
        {
            history = historiaService.pobierzHistorie();
        }
        else
        {
            history = historiaService.pobierzHistorieStolu(stol.getId());
        }
    }
}
