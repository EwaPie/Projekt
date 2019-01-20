package com.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Danie {
    private final String id = UUID.randomUUID().toString();
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
        return Objects.equals(id, danie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
