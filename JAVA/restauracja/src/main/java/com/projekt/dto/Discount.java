package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    public static final Discount EMPTY = new Discount();

    private Integer id;

    private String name;

    private BigDecimal netDiscountValue = BigDecimal.ZERO;

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

        return netDiscountValue == null || BigDecimal.ZERO.compareTo(netDiscountValue) == 0;
    }

}