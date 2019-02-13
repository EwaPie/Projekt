package com.projekt.service;

import com.projekt.dto.Table;
import com.projekt.mapper.TableMapper;
import com.projekt.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService {

    private TableMapper mapper = Mappers.getMapper(TableMapper.class);

    private final TableRepository tableRepository;

    public List<Table> getAll() {
        return mapper.entityToDto(tableRepository.findAll());
    }

    public void add(Table table) {
        tableRepository.save(mapper.dtoToEntity(table));
    }

    public void remove(Table table) {
        tableRepository.delete(mapper.dtoToEntity(table));
    }

    public Table getById(Integer id) {
        return mapper.entityToDto(tableRepository.findById(id).orElse(null));
    }
}
