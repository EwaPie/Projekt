package com.projekt.service;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.Table;
import com.projekt.mapper.TableMapper;
import com.projekt.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService {

    private TableMapper mapper = Mappers.getMapper(TableMapper.class);

    private final TableRepository tableRepository;

    public List<Table> getAll() {
        return mapper.entityToDto(tableRepository.findAll(), new CycleAvoidingMappingContext());
    }

    @Transactional
    public void add(Table table) {
        if (table.getId() != null) {
            Optional<com.projekt.model.Table> entity = tableRepository.findById(table.getId());

            if (entity.isPresent()) {
                tableRepository.save(mapper.merge(entity.get(), table));
                return;
            }
        }
        tableRepository.save(mapper.dtoToEntity(table, new CycleAvoidingMappingContext()));

    }

    public void remove(Table table) {
        tableRepository.deleteById(table.getId());
    }

    public Table getById(Integer id) {
        return mapper.entityToDto(tableRepository.findById(id).orElse(null), new CycleAvoidingMappingContext());
    }
}
