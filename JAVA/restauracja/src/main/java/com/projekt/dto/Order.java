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
    private BigDecimal cenaBruttoPoRabacie = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal cenaBrutto = BigDecimal.ZERO;

    @Getter
    @Builder.Default
    private List<DanieWrapper> dania = new ArrayList<>();

    @Builder.Default
    private boolean oplacony = false;
    @Builder.Default
    private boolean zamkniety = false;

    @Builder.Default
    private TypRachunku typRachunku = TypRachunku.PARAGON;

    @Setter
    @Builder.Default
    private Rabat rabat = new Rabat();

    public BigDecimal aktualnaWartosc() {
        BigDecimal wartosc = dania.stream().map(DanieWrapper::getCennaBruttoRazem).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        if (rabat != null) {
            wartosc = rabat.nalozRabat(wartosc);
        }
        return wartosc;
    }

    public BigDecimal wartoscBezRabatu() {
        return dania.stream().map(DanieWrapper::getCennaBruttoRazem).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Order dodajDanie(Danie danie) {
        DanieWrapper wrapper = dania
                .stream()
                .filter(d -> d.getDanie().equals(danie))
                .findAny()
                .orElseGet(() -> {
                    DanieWrapper w = new DanieWrapper(danie);
                    dania.add(w);
                    return w;
                });

        wrapper.setCount(wrapper.getCount() + 1);
        return this;
    }

    public static class OrderBuilder {
        public OrderBuilder dodajDanie(Danie danie) {
            if (dania == null) {
                dania = new ArrayList<>();
            }
            DanieWrapper wrapper = dania
                    .stream()
                    .filter(d -> d.getDanie().equals(danie))
                    .findAny()
                    .orElseGet(() -> {
                        DanieWrapper w = new DanieWrapper(danie);
                        dania.add(w);
                        return w;
                    });

            wrapper.setCount(wrapper.getCount() + 1);
            return this;
        }

        public OrderBuilder dodajDania(List<Danie> dania) {
            dania.forEach(this::dodajDanie);
            return this;
        }
    }

}
