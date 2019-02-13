package com.projekt.controller;

import com.projekt.dto.Order;
import com.projekt.dto.Table;
import com.projekt.service.TableService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("view")
public class HallController {

    private final TableService tableService;

    @Getter
    @Setter
    private List<Table> tables;

    @Getter
    @Setter
    private Table nowyStol = Table.builder().build();

    @Getter
    @Setter
    private boolean edycja = false;

    public HallController(TableService tableService) {
        this.tableService = tableService;
        refresh();
    }


    public void dodajStol() {
        if (!edycja) {
            tableService.add(nowyStol);
        }
        nowyStol = Table.builder().build();
        edycja = false;

        refresh();
    }

    public void usunStol(Table stol) {
        tableService.remove(stol);
        refresh();
    }

    public void edytujStol(Table stol) {
        nowyStol = stol;
        edycja = true;
    }

    public void anulujEdycje() {
        nowyStol = Table.builder().build();
        edycja = false;
    }

    private void refresh() {
        tables = tableService.getAll();
    }

    public String zamknietyClass(Order rachunek) {
        return rachunek.isClose() ? " close" : "";
    }

    public String oplaconyClass(Order rachunek) {
        return rachunek.isPaid() ? " paid" : "";
    }

    public String nowyClass(Order rachunek) {
        return !rachunek.isPaid() && !rachunek.isClose() ? " nowy" : "";
    }
}
