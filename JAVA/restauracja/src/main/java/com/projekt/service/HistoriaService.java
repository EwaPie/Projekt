package com.projekt.service;

import com.projekt.dto.Historia;
import com.projekt.repository.HistoryRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class HistoriaService {

    private final HistoryRepository historyRepository;

    @Inject
    public HistoriaService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void dodaj(Historia historia) {
        historyRepository.save(historia);
    }

    public List<Historia> pobierzHistorie() {
        return historyRepository.pobierzHistorie();
    }

    public List<Historia> pobierzHistorieStolu(Integer id) {
        return historyRepository.pobierzHistorieStolu(id);
    }
}
