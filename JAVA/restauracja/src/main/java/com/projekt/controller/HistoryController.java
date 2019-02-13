package com.projekt.controller;

import com.projekt.dto.History;
import com.projekt.service.HistoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("view")
public class HistoryController {

    @Getter
    @Setter
    private List<History> history;

    public HistoryController(HistoryService historyService) {
        history = historyService.getAll();
    }

}
