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
    private final RabatService rabatService;
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
    public StolController(StolService stolService, RabatService rabatService, HistoriaService historiaService) {
        this.stolService = stolService;
        this.rabatService = rabatService;
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
        stol.setRachunek(Order.builder().build());
    }

    public void oplac() {
        Order zamownie = stol.getRachunek();
        zamownie.setOplacony(true);
        BigDecimal wartoscZamowienia = zamownie
                .getDania()
                .stream()
                .map(DanieWrapper::getCennaBruttoRazem)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        zamownie.setCenaBrutto(wartoscZamowienia);
        zamownie.setCenaBruttoPoRabacie(zamownie.getRabat().nalozRabat(zamownie.getCenaBrutto()));
    }

    public void zamknij() {
        Order zamownie = stol.getRachunek();
        zamownie.setZamkniety(true);
        if (zamownie.getCenaBrutto().compareTo(BigDecimal.ZERO) != 0) {
            this.historiaService.dodaj(Historia.builder().stol(stol).zamowienie(stol.getRachunek()).build());
        }
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

    public void usunRabat() {
        Optional<Rabat> rabat = rabatService.getAll()
                .stream()
                .filter(r -> r.getNazwa().equalsIgnoreCase(rabatNazwa))
                .findAny();
        if (!rabat.isPresent()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bledna wartosc", "Podany rabat nie istnieje");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return;
        }
        stol.getRachunek().setRabat(Rabat.EMPTY);
        rabatNazwa = null;
    }
}
