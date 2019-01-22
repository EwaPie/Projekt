package com.projekt.repository;

import com.projekt.dto.Stol;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class StolHistoryRepository {

    private final List<Stol> history;

    public StolHistoryRepository() {
        this.history = new ArrayList<>();
    }

    public void save(Stol stol) {history.add(stol);}

    public List<Stol> pobierzHistorie() {return history;}
}
