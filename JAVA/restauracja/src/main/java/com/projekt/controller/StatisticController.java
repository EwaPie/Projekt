package com.projekt.controller;

import com.projekt.dto.*;
import com.projekt.service.DinnerService;
import com.projekt.service.HistoryService;
import com.projekt.service.TableService;
import lombok.RequiredArgsConstructor;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Controller
@Scope("view")
@RequiredArgsConstructor
public class StatisticController implements Serializable {

    private final HistoryService historyService;
    private final DinnerService dinnerService;
    private final TableService tableService;

    public PieChartModel createPieChart() {
        PieChartModel pieChart = new PieChartModel();
        pieChart.setTitle("Najchetniej kupowane danie");
        pieChart.setLegendPosition("w");
        pieChart.setShadow(false);

        for (Dinner dinner : dinnerService.getAll()) {
            long count = historyService
                    .getAll()
                    .stream()
                    .map(History::getOrder)
                    .map(Order::getDinners)
                    .flatMap(List::stream)
                    .filter(d -> d.getName().equals(dinner.getName()))
                    .mapToInt(DinnerWrapper::getCount)
                    .sum();

            pieChart.set(dinner.getName(), count);
        }
        return pieChart;
    }

    public BarChartModel amountPerTable() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Rozkład obrotu na stoliki");

        for (Table table : tableService.getAll()) {
            ChartSeries series = new ChartSeries();

            series.setLabel(table.getId().toString());

            BigDecimal count = historyService
                    .getAllByTableId(table.getId())
                    .stream()
                    .map(History::getOrder)
                    .map(Order::actualPrice)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            series.set(table.getId(), count);

            model.addSeries(series);
        }
        return model;
    }

    public BarChartModel dinnerPerTable() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Rozkład dań na stoliki");
        for (Dinner dinner : dinnerService.getAll()) {

            ChartSeries series = new ChartSeries();
            series.setLabel(dinner.getName());

            for (Table table : tableService.getAll()) {
                long count = historyService.getAllByTableId(table.getId())
                        .stream()
                        .map(History::getOrder)
                        .map(Order::getDinners)
                        .flatMap(List::stream)
                        .filter(d -> d.getName().equals(dinner.getName()))
                        .mapToInt(DinnerWrapper::getCount)
                        .sum();

                series.set(table.getId(), count);
            }
            model.addSeries(series);
        }
        return model;
    }
}


