package com.projekt.repository;

import com.projekt.dto.Historia;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class HistoryRepository {

    private final List<Historia> historia;

    public HistoryRepository() {
        this.historia = new ArrayList<>();
    }

    public void save(Historia historia) {this.historia.add(historia);}

    public List<Historia> pobierzHistorie() {return historia;}
}
