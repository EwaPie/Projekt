package com.projekt.controller;

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
    private Table table = Table.builder().build();

    @Getter
    @Setter
    private boolean edit = false;

    public HallController(TableService tableService) {
        this.tableService = tableService;
        refresh();
    }


    public void add() {
        tableService.add(table);
        table = Table.builder().build();
        edit = false;

        refresh();
    }

    public void remove(Table stol) {
        tableService.remove(stol);
        refresh();
    }

    public void editTable(Table stol) {
        table = stol;
        edit = true;
    }

    public void abortEdit() {
        table = Table.builder().build();
        edit = false;
    }

    private void refresh() {
        tables = tableService.getAll();
    }

}
