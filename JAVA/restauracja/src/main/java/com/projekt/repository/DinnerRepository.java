package com.projekt.repository;

import com.projekt.dto.Dinner;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class DinnerRepository {

    private final Set<Dinner> memory;

    public DinnerRepository() {
        this.memory = new HashSet<>();
        memory.add(Dinner.builder().name("Jajecznica").netPrice(BigDecimal.TEN).taxAmount(8).build());
        memory.add(Dinner.builder().name("Herbata").netPrice(BigDecimal.TEN).taxAmount(8).build());
    }

    public void save(Dinner dinner) {
        memory.add(dinner);
    }

    public List<Dinner> getAll() {
        return new ArrayList<>(memory);
    }

    public void usun(Dinner dinner) {
        memory.removeIf(entity -> entity.equals(dinner));
    }
}
