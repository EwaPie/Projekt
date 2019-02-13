package com.projekt.service;

import com.projekt.dto.History;
import com.projekt.mapper.HistoryMapper;
import com.projekt.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private HistoryMapper mapper = Mappers.getMapper(HistoryMapper.class);

    private final HistoryRepository historyRepository;

    public void add(History history) {
        historyRepository.save(mapper.dtoToEntity(history));
    }

    public List<History> getAll() {
        return mapper.entityToDto(historyRepository.findAll());
    }

    public List<History> getAllByTableId(Integer id) {
        return mapper.entityToDto(historyRepository.findByTable_Id(id));
    }

    public History getById(Integer id) {
        return mapper.entityToDto(historyRepository.findById(id).orElse(null));
    }
}
