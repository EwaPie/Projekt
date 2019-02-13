package com.projekt.controller;


import com.projekt.dto.History;
import com.projekt.service.HistoryService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class SzczegolyHistoriiController {

    private final HistoryService historyService;

    @Setter
    @Getter
    private String id;

    @Getter
    private History history;
    @Inject
    public SzczegolyHistoriiController(HistoryService historyService) {
        this.historyService = historyService;
        refresh();
    }

    public void refresh(){
        history = historyService.getById(id);}

}
