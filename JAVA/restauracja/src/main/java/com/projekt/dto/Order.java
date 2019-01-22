package com.projekt.dto;


import com.projekt.enums.TypRachunku;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private final String id = UUID.randomUUID().toString();
    @Builder.Default
    private BigDecimal cenaNettoPoRabacie = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal cenaNetto = BigDecimal.ZERO;

    @Getter
    @Builder.Default
    private List<Danie> dania = new ArrayList<>();

    @Builder.Default
    private boolean oplacony = false;
    @Builder.Default
    private boolean zamkniety = false;

    @Builder.Default
    private TypRachunku typRachunku = TypRachunku.PARAGON;

    @Setter
    @Builder.Default
    private Rabat rabat = null;

    public BigDecimal aktualnaWartosc() {
        BigDecimal wartosc = dania.stream().map(Danie::getCennaBrutto).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        if(rabat != null)
        {
            wartosc = wartosc.subtract(rabat.getWartoscZnizkiNetto());
        }
        return wartosc;
    }

    public BigDecimal wartoscBezRabatu()
    {
        return dania.stream().map(Danie::getCennaBrutto).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }


}
