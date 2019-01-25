package com.projekt.controller;

import com.projekt.dto.Stol;
import com.projekt.service.StolService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named
public class MenuBarController {

    private final StolService stolService;

    @Inject
    public MenuBarController(StolService stolService) {
        this.stolService = stolService;
    }

    @PostConstruct
    public void init() {
    }

    public List<Stol> getStoly() {
        return stolService.pobierzWszystkieStoly();
    }
}