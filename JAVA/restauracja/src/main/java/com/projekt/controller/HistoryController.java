package com.projekt.controller;


import com.projekt.dto.Historia;
import com.projekt.dto.Stol;
import com.projekt.service.HistoriaService;
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

    private final HistoriaService historiaService;
    private final StolService stolService;

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
    public HistoryController(HistoriaService historiaService, StolService stolService) {
        this.historiaService = historiaService;
        this.stolService = stolService;
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


    public List<Stol> pobierzDostepneStoly() {
        List<Stol> stoly =  this.stolService.pobierzWszystkieStoly();
        return stoly;
    }

    public List<Historia> pobierzHistorie()
    {
        refresh();
        return history;
    }
}
