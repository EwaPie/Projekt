package com.projekt.controller;

import com.projekt.dto.Table;
import com.projekt.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("view")
@RequiredArgsConstructor
public class MenuBarController {

    private final TableService tableService;

    public List<Table> getTable() {
        return tableService.getAll();
    }
}