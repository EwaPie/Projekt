package com.projekt.mapper;

import com.projekt.dto.Dinner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DinnerMapper {

    Dinner entityToDto(com.projekt.model.Dinner entity);
    List<Dinner> entityToDto(List<com.projekt.model.Dinner> entities);

    com.projekt.model.Dinner dtoToEntity(Dinner dto);
}
