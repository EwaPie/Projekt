package com.projekt.dto;

import com.projekt.enums.AccountType;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"dinners", "table"})
@ToString(exclude = {"dinners", "table"})
public class Order {

    private Integer id;

    private BigDecimal grossPrice = BigDecimal.ZERO;

    private List<DinnerWrapper> dinners = new ArrayList<>();

    private boolean paid = false;
    private boolean close = false;

    private AccountType accountType = AccountType.RECEIPT;

    private Discount discount = new Discount();

    private Table table;

    public BigDecimal actualPrice() {
        BigDecimal price = dinners.stream().map(DinnerWrapper::getTotalGrossPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        if (discount != null) {
            price = discount.applyDiscount(price);
        }
        return price;
    }

    public void addDinner(Dinner dinner) {
        DinnerWrapper wrapper = this.dinners
                .stream()
                .filter(d -> d.getDinner().equals(dinner))
                .findAny()
                .orElseGet(() -> {
                    DinnerWrapper w = new DinnerWrapper(dinner, this);
                    this.dinners.add(w);
                    return w;
                });

        wrapper.setCount(wrapper.getCount() + 1);
    }

}
