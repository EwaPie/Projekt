package com.projekt.mapper;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.Dinner;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {TableMapper.class, OrderMapper.class})
public interface DinnerMapper {

    Dinner entityToDto(com.projekt.model.Dinner entity, @Context CycleAvoidingMappingContext context);

    List<Dinner> entityToDto(List<com.projekt.model.Dinner> entities, @Context CycleAvoidingMappingContext context);

    com.projekt.model.Dinner dtoToEntity(Dinner dto, @Context CycleAvoidingMappingContext context);
}
