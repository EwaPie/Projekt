package com.projekt.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private Integer id;
    private Order order;
    private Table table;
}
