package com.projekt.service;

import com.projekt.dto.Discount;
import com.projekt.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public List<Discount> getAll(){return discountRepository.getAll();}

    public void add(Discount discount){discountRepository.save(discount);}

    public void remove(Discount discount){discountRepository.remove(discount);}


}
