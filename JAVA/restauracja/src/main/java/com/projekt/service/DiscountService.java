package com.projekt.service;

import com.projekt.dto.Discount;
import com.projekt.mapper.DiscountMapper;
import com.projekt.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private DiscountMapper mapper = Mappers.getMapper(DiscountMapper.class);

    private final DiscountRepository discountRepository;

    public Optional<Discount> findDiscount(String name) {
        return Optional.ofNullable(mapper.entityToDto(discountRepository.findByName(name)));
    }

    public List<Discount> getAll() {
        return mapper.entityToDto(discountRepository.findAll());
    }

    public void add(Discount discount) {
        discountRepository.save(mapper.dtoToEntity(discount));
    }

    public void remove(Discount discount) {
        discountRepository.delete(mapper.dtoToEntity(discount));
    }


}
