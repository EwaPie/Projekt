package com.projekt.repository;

import com.projekt.dto.Danie;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class DanieRepository {

    private final Set<Danie> memory;

    public DanieRepository() {
        this.memory = new HashSet<>();
        memory.add(Danie.builder().nazwa("Jajecznica").cenaNetto(BigDecimal.TEN).wysokoscPodatku(8).build());
        memory.add(Danie.builder().nazwa("Herbata").cenaNetto(BigDecimal.TEN).wysokoscPodatku(8).build());
    }

    public void save(Danie danie) {
        memory.add(danie);
    }

    public List<Danie> getAll() {
        return new ArrayList<>(memory);
    }

    public void usunDanie(Danie danie) {
        memory.removeIf(entity -> entity.equals(danie));
    }
}
