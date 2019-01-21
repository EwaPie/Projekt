package com.projekt.dto;

import com.projekt.enums.TypRachunku;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Rachunek {
    @Builder.Default
    private List<Danie> dania = new ArrayList<>();
    private String znizka;
    private TypRachunku typRachunku = TypRachunku.PARAGON;

    @Builder.Default
    private boolean oplacony = false;
    @Builder.Default
    private boolean zamkniety = false;

    public BigDecimal aktualnaWartosc() {
        return dania.stream().map(Danie::getCennaBrutto).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
