package com.projekt.dto;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
public class Danie {
    // jsf nie radzi sobie z id w formie UUID :/
    private static AtomicInteger ID = new AtomicInteger(0);

    @Builder.Default
    private final Integer id = ID.getAndIncrement();

    private String nazwa;
    @Builder.Default
    private BigDecimal cenaNetto = BigDecimal.ZERO;
    @Builder.Default
    private Integer wysokoscPodatku = 0;

    public BigDecimal getCennaBrutto() {
        return cenaNetto.multiply(BigDecimal.valueOf(((double) wysokoscPodatku / 100) + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Danie danie = (Danie) o;

        return new EqualsBuilder()
                .append(id, danie.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
