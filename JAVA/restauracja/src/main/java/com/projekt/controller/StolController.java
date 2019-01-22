package com.projekt.controller;

import com.projekt.dto.Danie;
import com.projekt.dto.Order;
import com.projekt.dto.Stol;
import com.projekt.service.DanieService;
import com.projekt.service.OrderService;
import com.projekt.service.StolService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class StolController {

    private final StolService stolService;
    private final DanieService danieService;
    private OrderService orderService;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Stol stol = Stol.builder().build();

    @Getter
    @Setter
    private Danie danie;

    @Inject
    public StolController(StolService stolService, DanieService danieService, OrderService orderService) {
        this.stolService = stolService;
        this.danieService = danieService;
        this.orderService = orderService;
    }

    public void refresh() {
        stol = stolService.getById(id);
    }

    public void dodajDoRachunku(Danie danie){stol.getRachunek().getDania().add(danie);}

    public void usunZRachunku(Danie danie) {
        stol.getRachunek().getDania().removeIf(d -> d.equals(danie));
    }

    public List<Danie> dostepneDania(String nazwa) {
        return danieService.pobierzWszystkieDania()
                .stream()
                .filter(d -> StringUtils.startsWithIgnoreCase(d.getNazwa(), nazwa))
                .collect(Collectors.toList());
    }

    public void otworzRachunek() {
        if(stol.getRachunek().getDania().size() > 0)
        {
            Order zamowienie = stol.getRachunek();
            zamowienie.setCenaNettoPoRabacie(zamowienie.aktualnaWartosc());
            zamowienie.setCenaNetto(zamowienie.wartoscBezRabatu());
            stol.setRachunek(zamowienie);
            stolService.dodajDoHistori(stol);
        }
        stol.setRachunek(Order.builder().build());
    }

    public void oplac() {
        stol.getRachunek().setOplacony(true);
    }

    public void zamknij() {
        stol.getRachunek().setZamkniety(true);
    }

    public void usunRabat(){stol.getRachunek().setRabat(null);}
}
