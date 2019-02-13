package com.projekt.dto;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Discount {

    public static final Discount EMPTY = new Discount();

    private final String id = UUID.randomUUID().toString();

    private String name;

    @Builder.Default
    private BigDecimal netDiscountValue = BigDecimal.ZERO;

    @Builder.Default
    private Integer percentage = 0;

    public BigDecimal applyDiscount(BigDecimal actualPrice) {
        if (percentage != null && percentage != 0) {
            BigDecimal afterDiscount = actualPrice.multiply(BigDecimal.valueOf(((double) 100 - percentage) / 100));
            return afterDiscount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : afterDiscount;
        } else if (netDiscountValue != null) {
            BigDecimal afterDiscount = actualPrice.subtract(netDiscountValue);
            return afterDiscount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : afterDiscount;
        }
        return actualPrice;
    }

    public boolean isEmpty() {
        if (percentage != null && percentage != 0) {
            return false;
        }

        return netDiscountValue == null;
    }

}
