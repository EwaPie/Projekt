package com.projekt.service;

import com.projekt.CycleAvoidingMappingContext;
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
        return toDto(orderRepository.findAll());
    }

    public void add(Order order) {
        this.orderRepository.save(toEntity(order));
    }

    private List<Order> toDto(List<com.projekt.model.Order> entities) {
        return mapper.entityToDto(entities, new CycleAvoidingMappingContext());
    }

    private com.projekt.model.Order toEntity(Order entity) {
        return mapper.dtoToEntity(entity, new CycleAvoidingMappingContext());
    }
}
