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
    public OrderRepository(DanieRepository danieRepository) {
        orders = new ArrayList<>();
        orders.add(Order
                .builder()
                .cenaNettoPoRabacie(new BigDecimal(20))
                .cenaNetto(new BigDecimal(30))
                .dania(danieRepository.getAll())
                .build());
    }

    public List<Order> getAll(){return orders;}

    public void save(Order order){
        System.out.println(order.getDania().size());
        orders.add(order);
    }
}
