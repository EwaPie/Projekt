package com.projekt.controller;


import com.projekt.dto.Order;
import com.projekt.repository.OrderRepository;
import lombok.Getter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class OrderController {

    private final OrderRepository orderRepository;

    @Getter
    private List<Order> orders;

    @Inject
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        refresh();
    }

    private void refresh(){orders = orderRepository.getAll();}

}
