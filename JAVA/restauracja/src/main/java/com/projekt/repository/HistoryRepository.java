package com.projekt.repository;

import com.projekt.dto.DanieWrapper;
import com.projekt.dto.Historia;
import com.projekt.dto.Order;
import org.springframework.util.LinkedMultiValueMap;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class HistoryRepository {

    private final Map<Integer, List<Historia>> historia;

    @Inject
    public HistoryRepository(StolRepository stolRepository, DanieRepository danieRepository) {
        this.historia = new LinkedMultiValueMap<>();
        List<Historia> fake = new ArrayList<>();
        DanieWrapper danie = new DanieWrapper(danieRepository.getAll().get(1));
        danie.setCount(1);
        List<DanieWrapper> fakeList = new ArrayList<>();
        fakeList.add(danie);
        fake.add(Historia
                .builder()
                .stol(stolRepository.getAll().get(1))
                .zamowienie(Order
                        .builder()
                        .dania(fakeList)
                        .cenaBrutto(new BigDecimal(20))
                        .cenaBruttoPoRabacie(new BigDecimal(10))
                        .build())
                .build());
       this.historia.computeIfAbsent(stolRepository.getAll().get(1).getId(), key -> fake);
    }

    public void save(Historia historia) {
        this.historia.computeIfAbsent(historia.getStol().getId(), key -> new LinkedList<>())
                .add(historia);
    }

    public List<Historia> pobierzHistorie() {
        return historia.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<Historia> pobierzHistorieStolu(Integer id) {
        return historia.getOrDefault(id, Collections.emptyList());
    }

    public Historia pobierzJedna(String id) {
        return historia
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(historia1 -> historia1.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
