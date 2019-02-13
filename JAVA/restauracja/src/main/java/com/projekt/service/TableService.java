package com.projekt.service;

import com.projekt.dto.Table;
import com.projekt.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    public List<Table> getAll() {
        return tableRepository.getAll();
    }

    public void add(Table table) {
        tableRepository.save(table);
    }

    public void remove(Table table) {
        tableRepository.usun(table);
    }

    public Table getById(Integer id) {
        return tableRepository.getById(id);
    }
}
