package com.projekt.mapper;

import com.projekt.dto.History;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {

    History entityToDto(com.projekt.model.History entity);

    List<History> entityToDto(List<com.projekt.model.History> entities);

    com.projekt.model.History dtoToEntity(History dto);
}
