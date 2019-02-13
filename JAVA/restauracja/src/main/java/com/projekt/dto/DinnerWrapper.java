package com.projekt.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@RequiredArgsConstructor
@ToString(callSuper = true)
public class DinnerWrapper {

    @Getter
    @Setter
    private Integer count = 0;

    @Getter
    private final Dinner dinner;

    private Integer getId() {
        return dinner.getId();
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
