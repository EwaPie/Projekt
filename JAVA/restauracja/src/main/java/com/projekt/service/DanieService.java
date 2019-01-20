package com.projekt.service;

import com.projekt.dto.Danie;
import com.projekt.repository.DanieRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DanieService {

    private final DanieRepository danieRepository;

    @Inject
    public DanieService(DanieRepository danieRepository) {
        this.danieRepository = danieRepository;
    }

    public List<Danie> pobierzWszystkieDania() {
        return danieRepository.getAll();
    }

    public void dodajDanie(Danie danie) {
        danieRepository.save(danie);
    }

    public void usunDanie(Danie danie) {
        danieRepository.usunDanie(danie);
    }
}
