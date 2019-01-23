package com.projekt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@RequiredArgsConstructor
@ToString(callSuper = true)
public class DanieWrapper {

    @Getter
    @Setter
    private Integer count = 0;

    @Getter
    private final Danie danie;

    private Integer getId() {
        return danie.getId();
    }

    public BigDecimal getCenaNetto() {
        return danie.getCenaNetto();
    }

    public String getNazwa() {
        return danie.getNazwa();
    }

    public Integer getWysokoscPodatku() {
        return danie.getWysokoscPodatku();
    }

    public BigDecimal getCennaBrutto() {
        return danie.getCennaBrutto();
    }

    public BigDecimal getCennaBruttoRazem() {
        return danie.getCennaBrutto().multiply(BigDecimal.valueOf(count));
    }
}
