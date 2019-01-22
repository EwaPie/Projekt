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

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Optional;

@Named
public class StolController {

    private final StolService stolService;
    private final DanieService danieService;
    private final RabatService rabatService;
    private final OrderService orderService;
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
    public StolController(StolService stolService, DanieService danieService, RabatService rabatService,
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
        if (stol.getRachunek().getDania().size() > 0) {
            this.historiaService.dodaj(Historia.builder().stol(stol).zamowienie(stol.getRachunek()).build());
        }
        stol.setRachunek(Order.builder().build());
    }

    public void oplac() {

        stol.getRachunek().setOplacony(true);
        Order zamownie = stol.getRachunek();
        BigDecimal wartoscZamowienia = zamownie
                .getDania()
                .stream()
                .map(DanieWrapper::getCennaBrutto)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        zamownie.setCenaNetto(wartoscZamowienia);
        zamownie.setCenaNettoPoRabacie(zamownie.getRabat().nalozRabat(zamownie.getCenaNetto()));

        stol.setRachunek(zamownie);
    }

    public void zamknij() {
        stol.getRachunek().setZamkniety(true);
    }

    public void dodajRabat() {
        Optional<Rabat> rabat = rabatService.getAll()
                .stream()
                .filter(r -> r.getNazwa().equalsIgnoreCase(rabatNazwa))
                .findAny();
        if (!rabat.isPresent()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Podany rabat nie istnieje");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }
        stol.getRachunek().setRabat(rabat.get());
    }
}
