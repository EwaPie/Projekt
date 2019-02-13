package com.projekt.service;

import com.projekt.dto.Order;
import com.projekt.mapper.OrderMapper;
import com.projekt.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    private final OrderRepository orderRepository;

    public List<Order> getAll() {
        return mapper.entityToDto(orderRepository.findAll());
    }

    public void add(Order order) {
        this.orderRepository.save(mapper.dtoToEntity(order));
    }
}
