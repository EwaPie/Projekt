package com.projekt.repository;

import com.projekt.dto.Discount;

import javax.inject.Named;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class DiscountRepository
{
    private final Set<Discount> rabaty;

    public DiscountRepository() {
        this.rabaty  = new HashSet<>();
        rabaty.add(Discount.builder().name("Domyslny").netDiscountValue(new BigDecimal(10)).build());
    }

    public void save(Discount rabat) {this.rabaty.add(rabat);}

    public List<Discount> getAll(){return new ArrayList<>(rabaty);}

    public void remove(Discount rabat){this.rabaty.removeIf(entity -> entity.equals(rabat));}

}
