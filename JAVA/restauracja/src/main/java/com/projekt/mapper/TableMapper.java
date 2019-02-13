package com.projekt.mapper;

import com.projekt.dto.Table;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TableMapper {

    Table entityToDto(com.projekt.model.Table entity);

    List<Table> entityToDto(List<com.projekt.model.Table> entities);

    com.projekt.model.Table dtoToEntity(Table dto);
}
