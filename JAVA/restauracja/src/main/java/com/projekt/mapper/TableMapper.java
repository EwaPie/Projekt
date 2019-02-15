package com.projekt.mapper;

import com.projekt.dto.Order;
import com.projekt.dto.Table;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper

public interface TableMapper {

    @BeforeMapping
    default void orderEntityToDto(@MappingTarget Table target, com.projekt.model.Table source) {
        final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

        target.setOrder(source
                .getOrders()
                .stream()
                .filter(order -> !order.isClose())
                .map(orderMapper::entityToDto)
                .findAny()
                .orElse(new Order()));
    }

    @BeforeMapping
    default void orderDtoToEntity(@MappingTarget com.projekt.model.Table target, Table source) {
        final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

        if (target.getOrders() == null) {
            target.setOrders(new ArrayList<>());
        }

        target.getOrders()
                .add(orderMapper.dtoToEntity(source
                .getOrder()));
    }

    @Mapping(target = "order", ignore = true)
    Table entityToDto(com.projekt.model.Table entity);

    List<Table> entityToDto(List<com.projekt.model.Table> entities);

    @Mapping(target = "orders", ignore = true)
    com.projekt.model.Table dtoToEntity(Table dto);

    default com.projekt.model.Table merge(com.projekt.model.Table base, Table toAdd) {
        base.setNumberOfSeats(toAdd.getNumberOfSeats());

        base.getOrders().removeIf(order -> order.getId().equals(toAdd.getOrder().getId()));
        final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
        base.getOrders().add(orderMapper.dtoToEntity(toAdd.getOrder()));

        return base;
    }
}
