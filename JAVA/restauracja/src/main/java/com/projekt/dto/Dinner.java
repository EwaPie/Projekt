package com.projekt.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
public class Dinner {
    // jsf nie radzi sobie z id w formie UUID :/
    private static AtomicInteger ID = new AtomicInteger(0);

    @Builder.Default
    private final Integer id = ID.getAndIncrement();

    private String name;
    @Builder.Default
    private BigDecimal netPrice = BigDecimal.ZERO;
    @Builder.Default
    private Integer taxAmount = 0;

    public BigDecimal getGrossPrice() {
        return netPrice.multiply(BigDecimal.valueOf(((double) taxAmount / 100) + 1));
    }
}
