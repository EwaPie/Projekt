package com.projekt.repository;


import com.projekt.dto.Danie;
import com.projekt.dto.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class OrderRepository {

    private final Set<Order> orders;

    @Inject
    public OrderRepository(DanieRepository danieRepository) {
        orders = new HashSet<>();
        orders.add(Order.builder().cenaNettoPoRabacie(new BigDecimal(20)).cenaNetto(new BigDecimal(30)).dania(new HashSet<Danie>(danieRepository.getAll())).build());
    }

    public List<Order> getAll(){return new ArrayList<>(orders);}

    public void save(Order order){orders.add(order);}
}
