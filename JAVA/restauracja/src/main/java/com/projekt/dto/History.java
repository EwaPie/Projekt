package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private Integer id;
    private Order order;
    private Table table;

    public History(Order order, Table table) {
        this.order = order;
        this.table = table;
    }
}
