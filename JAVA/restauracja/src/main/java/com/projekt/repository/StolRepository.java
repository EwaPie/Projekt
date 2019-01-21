package com.projekt.repository;

import com.projekt.dto.Danie;
import com.projekt.dto.Rachunek;
import com.projekt.dto.Stol;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class StolRepository {

    private final List<Stol> memory;

    public StolRepository() {
        this.memory = new ArrayList<>();
        Danie danie = Danie.builder().nazwa("Hej he").cenaNetto(BigDecimal.TEN).wysokoscPodatku(23).build();
        Danie danie1 = Danie.builder().nazwa("Hej he").cenaNetto(BigDecimal.ONE).wysokoscPodatku(8).build();
        Rachunek rachunek = Rachunek.builder().dania(new ArrayList<>(Arrays.asList(danie, danie1))).build();
        memory.add(Stol.builder().rachunek(rachunek).build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
        memory.add(Stol.builder().build());
    }

    public void save(Stol stol) {
        memory.add(stol);
    }

    public List<Stol> getAll() {
        return new ArrayList<>(memory);
    }

    public void usun(Stol stol) {
        memory.removeIf(entity -> entity.equals(stol));
    }

    public Stol getById(Integer id) {
        return memory.stream().filter(stol -> stol.getId().equals(id)).findAny().orElse(null);
    }
}
