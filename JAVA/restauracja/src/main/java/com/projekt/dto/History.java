package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.inject.Named;
import java.util.UUID;

@Named
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Getter
    private final String id = UUID.randomUUID().toString();
    @Getter
    private Order order;
    @Getter
    private Table table;
}
