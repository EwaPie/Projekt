package com.projekt.service;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.Dinner;
import com.projekt.mapper.DinnerMapper;
import com.projekt.repository.DinnerRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinnerService {

    private DinnerMapper mapper = Mappers.getMapper(DinnerMapper.class);

    private final DinnerRepository dinnerRepository;

    public List<Dinner> getAll() {

        return toDto(dinnerRepository.findAll());
    }

    public void add(Dinner dinner) {
        dinnerRepository.save(toEntity(dinner));
    }

    public void remove(Dinner dinner) {
        dinnerRepository.delete(toEntity(dinner));
    }

    private List<Dinner> toDto(List<com.projekt.model.Dinner> entities) {
        return mapper.entityToDto(entities, new CycleAvoidingMappingContext());
    }

    private com.projekt.model.Dinner toEntity(Dinner entity) {
        return mapper.dtoToEntity(entity, new CycleAvoidingMappingContext());
    }
}
