package com.projekt.mapper;


import com.projekt.dto.Discount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DiscountMapper {

    Discount entityToDto(com.projekt.model.Discount entity);

    List<Discount> entityToDto(List<com.projekt.model.Discount> entities);

    com.projekt.model.Discount dtoToEntity(Discount dto);
}
