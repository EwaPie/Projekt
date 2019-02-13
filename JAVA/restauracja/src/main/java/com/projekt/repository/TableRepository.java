package com.projekt.repository;

import com.projekt.dto.Dinner;
import com.projekt.dto.Order;
import com.projekt.dto.Table;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
public class TableRepository {

    private final List<Table> memory;

    public TableRepository() {
        this.memory = new ArrayList<>();
        Dinner dinner = Dinner.builder().name("Hej he").netPrice(BigDecimal.TEN).taxAmount(23).build();
        Dinner dinner1 = Dinner.builder().name("Hej he").netPrice(BigDecimal.ONE).taxAmount(8).build();
        Order rachunek = Order.builder().dodajDanie(dinner).dodajDanie(dinner1).build();
        memory.add(Table.builder().order(rachunek).build());
        memory.add(Table.builder().build());
        memory.add(Table.builder().build());
        memory.add(Table.builder().build());
        memory.add(Table.builder().build());
    }

    public void save(Table stol) {
        memory.add(stol);
    }

    public List<Table> getAll() {
        return new ArrayList<>(memory);
    }

    public void usun(Table stol) {
        memory.removeIf(entity -> entity.getId().equals(stol.getId()));
    }

    public Table getById(Integer id) {
        return memory.stream().filter(stol -> stol.getId().equals(id)).findAny().orElse(null);
    }
}
