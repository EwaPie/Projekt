package com.projekt.service;

import com.projekt.dto.Order;
import com.projekt.repository.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    @Inject
    public OrderService(OrderRepository orderRepository, OrderHistoryRepository orderHistoryRepository) {
        this.orderRepository = orderRepository;
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<Order> getAll(){return orderRepository.getAll();}

    public void save(Order newOrder) {this.orderRepository.save(newOrder);}

    public void toHistory(OrderHistory orderHistory) {this.orderHistoryRepository.save(orderHistory);}
}
