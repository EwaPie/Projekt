package com.projekt.mapper;

import com.projekt.CycleAvoidingMappingContext;
import com.projekt.dto.Discount;
import com.projekt.dto.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {TableMapper.class})
public interface OrderMapper {

    @BeforeMapping
    default void discountToEntity(@MappingTarget com.projekt.model.Order target, Order source) {
        if (source.getDiscount() != null && source.getDiscount().isEmpty()) {
            target.setDiscount(null);
        } else {
            final DiscountMapper discountMapper = Mappers.getMapper(DiscountMapper.class);
            target.setDiscount(discountMapper.dtoToEntity(source.getDiscount()));
        }
    }

    @BeforeMapping
    default void discountToDto(@MappingTarget Order target, com.projekt.model.Order source) {
        if (source.getDiscount() == null) {
            target.setDiscount(new Discount());
        } else {
            final DiscountMapper discountMapper = Mappers.getMapper(DiscountMapper.class);
            target.setDiscount(discountMapper.entityToDto(source.getDiscount()));
        }
    }

    @Mapping(target = "discount", ignore = true)
    Order entityToDto(com.projekt.model.Order entity, @Context CycleAvoidingMappingContext context);

    List<Order> entityToDto(List<com.projekt.model.Order> entities, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "discount", ignore = true)
    com.projekt.model.Order dtoToEntity(Order dto, @Context CycleAvoidingMappingContext context);
}
