package com.projekt.repository;

import com.projekt.dto.Rabat;

import javax.inject.Named;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class RabatRepository
{
    private final Set<Rabat> rabaty;

    public RabatRepository() {
        this.rabaty  = new HashSet<>();
        rabaty.add(Rabat.builder().nazwa("Domyslny").wartoscZnizkiNetto(new BigDecimal(10)).build());
    }

    public void save(Rabat rabat) {this.rabaty.add(rabat);}

    public List<Rabat> getAll(){return new ArrayList<>(rabaty);}

    public void remove(Rabat rabat){this.rabaty.removeIf(entity -> entity.equals(rabat));}

}
