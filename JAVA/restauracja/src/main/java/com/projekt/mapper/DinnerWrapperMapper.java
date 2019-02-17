package com.projekt.mapper;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.DinnerWrapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {TableMapper.class, OrderMapper.class})
public interface DinnerWrapperMapper {

    DinnerWrapper entityToDto(com.projekt.model.DinnerWrapper entity, @Context CycleAvoidingMappingContext context);

    List<DinnerWrapper> entityToDto(List<com.projekt.model.DinnerWrapper> entities, @Context CycleAvoidingMappingContext context);

    com.projekt.model.DinnerWrapper dtoToEntity(DinnerWrapper dto, @Context CycleAvoidingMappingContext context);
}
