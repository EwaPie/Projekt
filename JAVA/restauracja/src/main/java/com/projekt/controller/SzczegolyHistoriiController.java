package com.projekt.controller;


import com.projekt.dto.Historia;
import com.projekt.dto.Stol;
import com.projekt.service.HistoriaService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class SzczegolyHistoriiController {

    private final HistoriaService historiaService;

    @Setter
    @Getter
    private String id;

    @Getter
    private Historia historia;
    @Inject
    public SzczegolyHistoriiController(HistoriaService historiaService) {
        this.historiaService = historiaService;
        refresh();
    }

    public void refresh(){historia = historiaService.pojedynczaHistoria(id);}

}
