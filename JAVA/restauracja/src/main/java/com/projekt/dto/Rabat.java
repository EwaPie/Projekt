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
public class Rabat {

    private final String id = UUID.randomUUID().toString();
    private String nazwa;
    @Builder.Default
    private BigDecimal wartoscZnizkiNetto = BigDecimal.ZERO;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
