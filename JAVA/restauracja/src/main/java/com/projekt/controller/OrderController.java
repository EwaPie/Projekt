package com.projekt.controller;

import com.projekt.dto.Dinner;
import com.projekt.dto.Order;
import com.projekt.service.OrderService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("view")
public class OrderController {

    private final OrderService orderService;

    @Getter
    @Setter
    private List<Dinner> items;

    @Getter
    private List<Order> orders;

    @Getter
    @Setter
    private Order order;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

        items = new ArrayList<>();
        order = new Order();
        refresh();
    }

    public void addToOrder(Dinner dinner) {
        items.add(dinner);
    }

    public void removeFromOrder(Dinner dinner) {
        items.remove(dinner);
    }

    public void makeOrder() {
        for (Dinner dinner : items) {
            order.addDinner(dinner);
        }
        if (order.getDiscount().isEmpty()) {
            order.setDiscount(null);
        }

        orderService.add(order);
        items = new ArrayList<>();

        refresh();
    }

    private void refresh() {
        orders = orderService.getAll();
    }


}