package com.projekt.repository;

import com.projekt.dto.Historia;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
public class HistoryRepository {

    private final Map<Integer, List<Historia>> historia;

    public HistoryRepository() {
        this.historia = new LinkedMultiValueMap<>();
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
}
