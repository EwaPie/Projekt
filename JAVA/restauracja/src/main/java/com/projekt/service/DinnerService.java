package com.projekt.service;

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

        return mapper.entityToDto(dinnerRepository.findAll());
    }

    public void add(Dinner dinner) {
        dinnerRepository.save(mapper.dtoToEntity(dinner));
    }

    public void remove(Dinner dinner) {
        dinnerRepository.delete(mapper.dtoToEntity(dinner));
    }
}
