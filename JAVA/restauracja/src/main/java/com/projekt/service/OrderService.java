package com.projekt.service;

import com.projekt.dto.Order;
import com.projekt.repository.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderService {

    private final OrderRepository orderRepository;

    @Inject
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){return orderRepository.getAll();}
}
