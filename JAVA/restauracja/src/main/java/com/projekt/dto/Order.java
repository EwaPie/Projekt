package com.projekt.dto;

import com.projekt.enums.AccountType;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;

    @Builder.Default
    private BigDecimal grossPrice = BigDecimal.ZERO;

    @Builder.Default
    private List<DinnerWrapper> dinners = new ArrayList<>();

    @Builder.Default
    private boolean paid = false;
    @Builder.Default
    private boolean close = false;

    @Builder.Default
    private AccountType accountType = AccountType.RECEIPT;

    @Builder.Default
    private Discount discount = new Discount();

    public BigDecimal actualPrice() {
        BigDecimal price = dinners.stream().map(DinnerWrapper::getTotalGrossPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        if (discount != null) {
            price = discount.applyDiscount(price);
        }
        return price;
    }

    public Order addDinner(Dinner dinner) {
        DinnerWrapper wrapper = this.dinners
                .stream()
                .filter(d -> d.getDinner().equals(dinner))
                .findAny()
                .orElseGet(() -> {
                    DinnerWrapper w = new DinnerWrapper(dinner);
                    this.dinners.add(w);
                    return w;
                });

        wrapper.setCount(wrapper.getCount() + 1);
        return this;
    }

    public static class OrderBuilder {
        public OrderBuilder addDinner(Dinner dinner) {
            if (dinner == null) {
                dinners = new ArrayList<>();
            }
            DinnerWrapper wrapper = dinners
                    .stream()
                    .filter(d -> d.getDinner().equals(dinner))
                    .findAny()
                    .orElseGet(() -> {
                        DinnerWrapper w = new DinnerWrapper(dinner);
                        dinners.add(w);
                        return w;
                    });

            wrapper.setCount(wrapper.getCount() + 1);
            return this;
        }

        public OrderBuilder addDinners(List<Dinner> dinners) {
            dinners.forEach(this::addDinner);
            return this;
        }
    }

}
