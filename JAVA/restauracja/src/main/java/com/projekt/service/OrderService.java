package com.projekt.service;

import com.projekt.dto.Order;
import com.projekt.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAll(){return orderRepository.getAll();}

    public void add(Order newOrder) {this.orderRepository.save(newOrder);}
}
