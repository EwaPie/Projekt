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
public class Rabat {

    private final String id = UUID.randomUUID().toString();

    @Getter
    private String nazwa;
    @Builder.Default
    private BigDecimal wartoscZnizkiNetto = BigDecimal.ZERO;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rabat rabat = (Rabat) o;

        return new EqualsBuilder()
                .append(id, rabat.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
