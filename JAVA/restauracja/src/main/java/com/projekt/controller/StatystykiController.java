package com.projekt.controller;

import com.projekt.dto.Danie;
import com.projekt.dto.DanieWrapper;
import com.projekt.dto.Historia;
import com.projekt.dto.Order;
import com.projekt.dto.Stol;
import com.projekt.service.DanieService;
import com.projekt.service.HistoriaService;
import com.projekt.service.StolService;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
public class StatystykiController implements Serializable {
    private final HistoriaService historiaService;
    private final DanieService danieService;
    private final StolService stolService;

    @Inject
    public StatystykiController(HistoriaService historiaService, DanieService danieService, StolService stolService) {
        this.historiaService = historiaService;
        this.danieService = danieService;

        this.stolService = stolService;
    }


    public PieChartModel createPieChart() {
        PieChartModel pieChart = new PieChartModel();
        pieChart.setTitle("Najchetniej kupowane danie");
        pieChart.setLegendPosition("w");
        pieChart.setShadow(false);

        for (Danie danie : danieService.pobierzWszystkieDania()) {
            long count = historiaService
                    .pobierzHistorie()
                    .stream()
                    .map(Historia::getZamowienie)
                    .map(Order::getDania)
                    .flatMap(List::stream)
                    .filter(d -> d.getNazwa().equals(danie.getNazwa()))
                    .map(DanieWrapper::getCount)
                    .reduce((i1, i2) -> i1 + i2)
                    .orElse(0);

            pieChart.set(danie.getNazwa(), count);
        }
        return pieChart;
    }

//    public PieChartModel rozkladKwot()
//    {
//        PieChartModel pieChart = new PieChartModel();
//        pieChart.setTitle("Rozkład obrotu ");
//        pieChart.setLegendPosition("w");
//        pieChart.setShadow(false);
//        for(Stol szukanyStol : stolService.pobierzWszystkieStoly()) {
//            BigDecimal count = historiaService
//                    .pobierzHistorie()
//                    .stream()
//                    .map(Historia::getZamowienie)
//                    .map(Order::getCenaBruttoPoRabacie)
//                    .reduce(BigDecimal::add)
//                    .orElse(BigDecimal.ZERO);
//            pieChart.set("Stol: " + szukanyStol.getId().toString(), count);
//        }
//        return pieChart;
//    }

    public BarChartModel rozkladKwotNaStolik() {
        BarChartModel model = new BarChartModel();
        model.setTitle("Rozkład dań na stoliki");

        for (Stol stol : stolService.pobierzWszystkieStoly()) {
            ChartSeries seria = new ChartSeries();

            seria.setLabel(stol.getId().toString());

            BigDecimal count = historiaService
                    .pobierzHistorieStolu(stol.getId())
                    .stream()
                    .map(Historia::getZamowienie)
                    .map(Order::getCenaBruttoPoRabacie)
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
        for (Danie danie : danieService.pobierzWszystkieDania()) {

            ChartSeries seria = new ChartSeries();
            seria.setLabel(danie.getNazwa());

            for (Stol stol : stolService.pobierzWszystkieStoly()) {
                long count = historiaService.pobierzHistorieStolu(stol.getId())
                        .stream()
                        .map(Historia::getZamowienie)
                        .map(Order::getDania)
                        .flatMap(List::stream)
                        .filter(d -> d.getNazwa().equals(danie.getNazwa()))
                        .map(DanieWrapper::getCount)
                        .reduce((i1, i2) -> i1 + i2)
                        .orElse(0);

                seria.set(stol.getId(), count);
            }
            model.addSeries(seria);
        }
        return model;
    }
}


