package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    private Integer id;

    @Builder.Default
    private Integer numberOfSeats = 5;

    @Builder.Default
    private Order order = Order.builder().build();

}
