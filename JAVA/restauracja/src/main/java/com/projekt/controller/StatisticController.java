package com.projekt.controller;

import com.projekt.dto.Dinner;
import com.projekt.dto.DinnerWrapper;
import com.projekt.dto.History;
import com.projekt.dto.Order;
import com.projekt.dto.Table;
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
        pieChart.setTitle("Najchetniej kupowane newDinner");
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
                    .map(DinnerWrapper::getCount)
                    .reduce((i1, i2) -> i1 + i2)
                    .orElse(0);

            pieChart.set(dinner.getName(), count);
        }
        return pieChart;
    }

    public BarChartModel rozkladKwotNaStolik() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Rozkład obrotu na stoliki");

        for (Table stol : tableService.getAll()) {
            ChartSeries seria = new ChartSeries();

            seria.setLabel(stol.getId().toString());

            BigDecimal count = historyService
                    .getAllByTableId(stol.getId())
                    .stream()
                    .map(History::getOrder)
                    .map(order -> order.getDiscount().applyDiscount(order.getGrossPrice()))
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO);

            seria.set(stol.getId(), count);

            model.addSeries(seria);
        }
        return model;
    }

    public BarChartModel daniaNaStoliki() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Rozkład dań na stoliki");
        for (Dinner dinner : dinnerService.getAll()) {

            ChartSeries seria = new ChartSeries();
            seria.setLabel(dinner.getName());

            for (Table stol : tableService.getAll()) {
                long count = historyService.getAllByTableId(stol.getId())
                        .stream()
                        .map(History::getOrder)
                        .map(Order::getDinners)
                        .flatMap(List::stream)
                        .filter(d -> d.getName().equals(dinner.getName()))
                        .map(DinnerWrapper::getCount)
                        .reduce((i1, i2) -> i1 + i2)
                        .orElse(0);

                seria.set(stol.getId(), count);
            }
            model.addSeries(seria);
        }
        return model;
    }
}


