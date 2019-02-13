package com.projekt.service;

import com.projekt.dto.History;
import com.projekt.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    public void add(History history) {
        historyRepository.save(history);
    }

    public List<History> getAll() {
        return historyRepository.pobierzHistorie();
    }

    public List<History> getAllByTableId(Integer id) {
        return historyRepository.pobierzHistorieStolu(id);
    }

    public History getById(String id) {return historyRepository.pobierzJedna(id);}
}
