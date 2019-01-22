package com.projekt.service;

import com.projekt.dto.Stol;
import com.projekt.repository.HistoryRepository;
import com.projekt.repository.StolRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StolService {

    private final StolRepository stolRepository;
    private final HistoryRepository stolHistory;

    @Inject
    public StolService(StolRepository stolRepository, HistoryRepository stolHistoryRepository) {
        this.stolRepository = stolRepository;
        this.stolHistory = stolHistoryRepository;
    }

    public List<Stol> pobierzWszystkieStoly() {
        return stolRepository.getAll();
    }

    public void dodaj(Stol stol) {
        stolRepository.save(stol);
    }

    public void usun(Stol stol) {
        stolRepository.usun(stol);
    }

    public Stol getById(Integer id) {
        return stolRepository.getById(id);
    }
}
