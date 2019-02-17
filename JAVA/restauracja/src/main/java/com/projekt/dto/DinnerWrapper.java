package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class DinnerWrapper {

    private Integer id;

    private Integer count = 0;

    private Dinner dinner;

    private Order order;

    public DinnerWrapper(Dinner dinner, Order order) {
        this.dinner = dinner;
        this.order = order;
    }

    public BigDecimal getNetPrice() {
        return dinner.getNetPrice();
    }

    public String getName() {
        return dinner.getName();
    }

    public Integer getTaxAmount() {
        return dinner.getTaxAmount();
    }

    public BigDecimal getGrossPrice() {
        return dinner.getGrossPrice();
    }

    public BigDecimal getTotalGrossPrice() {
        return dinner.getGrossPrice().multiply(BigDecimal.valueOf(count));
    }
}
