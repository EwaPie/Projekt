package com.projekt.controller;


import com.projekt.dto.Danie;
import com.projekt.dto.Order;
import com.projekt.service.OrderService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class OrderController {

    private final OrderService orderService;

    @Getter
    @Setter
    private List<Danie> items;

    @Getter
    private List<Order> orders;

    @Getter
    @Setter
    private Order newOrder;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        items = new ArrayList<>();
        newOrder = new Order();
        refresh();
    }

    public void addToOrder(Danie danie) {
        items.add(danie);
    }

    public void usunItem(Danie danie)
    {
        items.remove(danie);
    }

    public void makeOrder()
    {
        for (Danie danie: items) {
            newOrder.dodajDanie(danie);
        }
        orderService.save(newOrder);
        items = new ArrayList<>();

        refresh();
    }

    private void refresh(){orders = orderService.getAll();}



}