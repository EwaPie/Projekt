package com.projekt.repository;


import com.projekt.dto.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderRepository {

    private final List<Order> orders;

    @Inject
    public OrderRepository(DinnerRepository dinnerRepository) {
        orders = new ArrayList<>();
        orders.add(Order
                .builder()
                .grossPrice(new BigDecimal(30))
                .dodajDania(dinnerRepository.getAll())
                .build());
    }

    public List<Order> getAll(){return orders;}

    public void save(Order order){
        orders.add(order);
    }
}
