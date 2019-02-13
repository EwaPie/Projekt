package com.projekt.dto;

import com.projekt.enums.AccountType;
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
    private BigDecimal grossPrice = BigDecimal.ZERO;

    @Getter
    @Builder.Default
    private List<DinnerWrapper> dania = new ArrayList<>();

    @Builder.Default
    private boolean paid = false;
    @Builder.Default
    private boolean close = false;

    @Builder.Default
    private AccountType accountType = AccountType.RECEIPT;

    @Setter
    @Builder.Default
    private Discount discount = new Discount();

    public BigDecimal actualPrice() {
        BigDecimal price = dania.stream().map(DinnerWrapper::getTotalGrossPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        if (discount != null) {
            price = discount.applyDiscount(price);
        }
        return price;
    }

    public Order dodajDanie(Dinner dinner) {
        DinnerWrapper wrapper = dania
                .stream()
                .filter(d -> d.getDinner().equals(dinner))
                .findAny()
                .orElseGet(() -> {
                    DinnerWrapper w = new DinnerWrapper(dinner);
                    dania.add(w);
                    return w;
                });

        wrapper.setCount(wrapper.getCount() + 1);
        return this;
    }

    public static class OrderBuilder {
        public OrderBuilder dodajDanie(Dinner dinner) {
            if (dania == null) {
                dania = new ArrayList<>();
            }
            DinnerWrapper wrapper = dania
                    .stream()
                    .filter(d -> d.getDinner().equals(dinner))
                    .findAny()
                    .orElseGet(() -> {
                        DinnerWrapper w = new DinnerWrapper(dinner);
                        dania.add(w);
                        return w;
                    });

            wrapper.setCount(wrapper.getCount() + 1);
            return this;
        }

        public OrderBuilder dodajDania(List<Dinner> dania) {
            dania.forEach(this::dodajDanie);
            return this;
        }
    }

}
