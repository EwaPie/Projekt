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
    private Order newOrder;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

        items = new ArrayList<>();
        newOrder = new Order();
        refresh();
    }

    public void addToOrder(Dinner dinner) {
        items.add(dinner);
    }

    public void usunItem(Dinner dinner)
    {
        items.remove(dinner);
    }

    public void makeOrder()
    {
        for (Dinner dinner : items) {
            newOrder.dodajDanie(dinner);
        }
        orderService.add(newOrder);
        items = new ArrayList<>();

        refresh();
    }

    private void refresh(){orders = orderService.getAll();}



}