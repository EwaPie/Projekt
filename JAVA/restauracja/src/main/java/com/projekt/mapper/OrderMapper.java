package com.projekt.mapper;

import com.projekt.dto.Order;
import com.projekt.dto.Table;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order entityToDto(com.projekt.model.Order entity);

    List<Order> entityToDto(List<com.projekt.model.Order> entities);

    com.projekt.model.Order dtoToEntity(Order dto);
}
