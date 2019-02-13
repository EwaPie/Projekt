package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    public static final Discount EMPTY = new Discount();

    private String id;

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
