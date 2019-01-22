package com.projekt.controller;


import com.projekt.dto.Historia;
import com.projekt.repository.HistoryRepository;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class HistoryController {

    private final HistoryRepository historyRepository;

    @Getter
    @Setter
    private List<Historia> history;

    @Inject
    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        refresh();
    }

    public void refresh(){history = historyRepository.pobierzHistorie();}
}
