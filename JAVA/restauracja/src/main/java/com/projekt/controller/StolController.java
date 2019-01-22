package com.projekt.controller;

import com.projekt.dto.Danie;
import com.projekt.dto.DanieWrapper;
import com.projekt.dto.Historia;
import com.projekt.dto.Order;
import com.projekt.dto.Rabat;
import com.projekt.dto.Stol;
import com.projekt.service.DanieService;
import com.projekt.service.RabatService;
import com.projekt.service.HistoriaService;
import com.projekt.service.OrderService;
import com.projekt.service.StolService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.util.StringUtils;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class StolController {

    private final StolService stolService;
    private final DanieService danieService;
    private final RabatService rabatService;
    private OrderService orderService;
    private final HistoriaService historiaService;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Stol stol = Stol.builder().build();

    @Getter
    @Setter
    private Danie danie;

    @Getter
    @Setter
    private String rabatNazwa;

    @Inject
    public StolController(StolService stolService, DanieService danieService, RabatService rabatService) {
    public StolController(StolService stolService,
                          DanieService danieService,
                          OrderService orderService,
                          HistoriaService historiaService) {
        this.stolService = stolService;
        this.danieService = danieService;
        this.rabatService = rabatService;
        this.orderService = orderService;
        this.historiaService = historiaService;
    }

    public void refresh() {
        stol = stolService.getById(id);
    }

    public void dodajDoRachunku(Danie danie) {
        stol.getRachunek().dodajDanie(danie);
    }

    public void usunZRachunku(DanieWrapper danie) {
        stol.getRachunek().getDania().removeIf(d -> d.equals(danie));
    }

    public void usunJeden(DanieWrapper danie) {
        danie.setCount(danie.getCount() - 1);
        if (danie.getCount() < 1) {
            usunZRachunku(danie);
        }
    }

    public void otworzRachunek() {
        if(stol.getRachunek().getDania().size() > 0)
        {
            this.historiaService.dodaj(Historia.builder().stol(stol).zamowienie(stol.getRachunek()).build());
        }
        stol.setRachunek(Order.builder().build());
    }

    public void oplac() {

        stol.getRachunek().setOplacony(true);
        Order zamownie = stol.getRachunek();
        BigDecimal wartoscZamowienia = (zamownie
                .getDania()
                .stream()
                .map(Danie::getCennaBrutto)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO));
        zamownie.setCenaNetto(wartoscZamowienia);
        if(zamownie.getRabat() == null)
        {
            zamownie.setCenaNettoPoRabacie(wartoscZamowienia);
        }
        else
        {
            zamownie.setCenaNettoPoRabacie(wartoscZamowienia.subtract(zamownie.getRabat().getWartoscZnizkiNetto()));
        }

        stol.setRachunek(zamownie);
    }

    public void zamknij() {
        stol.getRachunek().setZamkniety(true);
    }

    public void usunRabat(){stol.getRachunek().setRabat(null);}
}
