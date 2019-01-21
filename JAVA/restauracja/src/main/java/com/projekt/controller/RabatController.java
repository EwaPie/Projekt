package com.projekt.controller;

import com.projekt.dto.Rabat;
import com.projekt.service.RabatService;
import lombok.Getter;
import lombok.Setter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.math.BigDecimal;
import java.text.DecimalFormat;



@Named
@ViewScoped
public class RabatController
{

    private final RabatService rabatService;

    @Getter
    private List<Rabat> rabaty;

    @Getter
    @Setter
    private Rabat nowyRabat;

    @Getter
    @Setter
    private boolean edycja = false;

    @Inject
    public RabatController(RabatService rabatService) {
        this.rabatService = rabatService;
        nowyRabat = new Rabat();
        refresh();
    }

    private void refresh(){rabaty = rabatService.getAll();}

    public void dodajRabat() {
        rabatService.dodajRabat(nowyRabat);
        nowyRabat = new Rabat();
        if (edycja) {
            edycja = false;
        }
        refresh();
    }

    public String formatPrice(BigDecimal value) {

        DecimalFormat df = new DecimalFormat();

        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        return df.format(value);
    }

    public void usunRabat(Rabat rabat){
        this.rabatService.usunRabat(rabat);
        refresh();
    }

    public void edytujDanie(Rabat rabat) {
        nowyRabat = rabat;
        edycja = true;
    }

    public void anulujEdycje() {
        nowyRabat = new Rabat();
        edycja = false;
    }
}