package com.projekt.controller;


import com.projekt.dto.History;
import com.projekt.service.HistoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Controller
@Scope("view")
@RequiredArgsConstructor
public class HistoryDetailsController {

    private final HistoryService historyService;

    @Setter
    @Getter
    private Integer id;

    @Getter
    private History history;

    public void refresh(){
        history = historyService.getById(id);}

}
