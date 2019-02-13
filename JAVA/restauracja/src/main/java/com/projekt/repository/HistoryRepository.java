package com.projekt.repository;

import com.projekt.dto.DinnerWrapper;
import com.projekt.dto.History;
import com.projekt.dto.Order;
import org.springframework.util.LinkedMultiValueMap;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class HistoryRepository {

    private final Map<Integer, List<History>> historia;

    @Inject
    public HistoryRepository(TableRepository tableRepository, DinnerRepository dinnerRepository) {
        this.historia = new LinkedMultiValueMap<>();
        List<History> fake = new ArrayList<>();
        DinnerWrapper danie = new DinnerWrapper(dinnerRepository.getAll().get(1));
        danie.setCount(1);
        List<DinnerWrapper> fakeList = new ArrayList<>();
        fakeList.add(danie);
        fake.add(History
                .builder()
                .table(tableRepository.getAll().get(1))
                .order(Order
                        .builder()
                        .dania(fakeList)
                        .grossPrice(new BigDecimal(20))
                        .build())
                .build());
       this.historia.computeIfAbsent(tableRepository.getAll().get(1).getId(), key -> fake);
    }

    public void save(History history) {
        this.historia.computeIfAbsent(history.getTable().getId(), key -> new LinkedList<>())
                .add(history);
    }

    public List<History> pobierzHistorie() {
        return historia.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<History> pobierzHistorieStolu(Integer id) {
        return historia.getOrDefault(id, Collections.emptyList());
    }

    public History pobierzJedna(String id) {
        return historia
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(historia1 -> historia1.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
