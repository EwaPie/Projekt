package com.projekt.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Dinner {

    private Integer id;

    private String name;
    @Builder.Default
    private BigDecimal netPrice = BigDecimal.ZERO;

    @Builder.Default
    private Integer taxAmount = 0;

    public BigDecimal getGrossPrice() {
        return netPrice.multiply(BigDecimal.valueOf(((double) taxAmount / 100) + 1));
    }
}
