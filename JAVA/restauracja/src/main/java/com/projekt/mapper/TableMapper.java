package com.projekt.mapper;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.Order;
import com.projekt.dto.Table;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper

public interface TableMapper {

    @BeforeMapping
    default void orderEntityToDto(@MappingTarget Table target, com.projekt.model.Table source, @Context CycleAvoidingMappingContext context) {
        final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

        target.setOrder(source
                .getOrders()
                .stream()
                .filter(order -> !order.isClose())
                .map(order -> orderMapper.entityToDto(order, context))
                .findAny()
                .orElse(new Order()));
    }

    @Mapping(target = "order", ignore = true)
    Table entityToDto(com.projekt.model.Table entity, @Context CycleAvoidingMappingContext context);

    List<Table> entityToDto(List<com.projekt.model.Table> entities, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "orders", ignore = true)
    com.projekt.model.Table dtoToEntity(Table dto, @Context CycleAvoidingMappingContext context);

    default com.projekt.model.Table merge(com.projekt.model.Table base, Table toAdd) {
        base.setNumberOfSeats(toAdd.getNumberOfSeats());

        base.getOrders().removeIf(order -> order.getId().equals(toAdd.getOrder().getId()));
        final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
        com.projekt.model.Order order = orderMapper.dtoToEntity(toAdd.getOrder(), new CycleAvoidingMappingContext());
        order.setTable(base);
        base.getOrders().add(order);

        return base;
    }
}
