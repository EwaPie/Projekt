package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    private Integer id;

    private Integer numberOfSeats = 5;

    private Order order = new Order();

}
