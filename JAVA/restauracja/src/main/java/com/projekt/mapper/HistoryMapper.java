package com.projekt.mapper;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.History;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {TableMapper.class, OrderMapper.class})
public interface HistoryMapper {


    @Mapping(source = "order", target = "order")
    @Mapping(source = "table", target = "table")
    History entityToDto(com.projekt.model.History entity, @Context CycleAvoidingMappingContext context);

    List<History> entityToDto(List<com.projekt.model.History> entities, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "order", target = "order")
    @Mapping(source = "table", target = "table")
    com.projekt.model.History dtoToEntity(History dto, @Context CycleAvoidingMappingContext context);
}
