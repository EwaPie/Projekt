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

    public static final Rabat EMPTY = new Rabat();

    private final String id = UUID.randomUUID().toString();

    @Getter
    private String nazwa;
    @Builder.Default
    private BigDecimal wartoscZnizkiNetto = BigDecimal.ZERO;

    @Builder.Default
    private Integer wartoscProcentowa = 0;

    public BigDecimal nalozRabat(BigDecimal aktualnaCena) {
        if (wartoscProcentowa != null && wartoscProcentowa != 0) {
            BigDecimal poRabacie = aktualnaCena.multiply(BigDecimal.valueOf(((double) 100 - wartoscProcentowa) / 100));
            return poRabacie.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : poRabacie;
        } else if (wartoscZnizkiNetto != null) {
            BigDecimal poRabacie = aktualnaCena.subtract(wartoscZnizkiNetto);
            return poRabacie.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : poRabacie;
        }
        return aktualnaCena;
    }

    public boolean isEmpty() {
        if (wartoscProcentowa != null && wartoscProcentowa != 0) {
            return false;
        }

        return wartoscZnizkiNetto == null;
    }

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
