package com.projekt.service;

import com.projekt.dto.Dinner;
import com.projekt.repository.DinnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinnerService {

    private final DinnerRepository dinnerRepository;

    public List<Dinner> getAll() {
        return dinnerRepository.getAll();
    }

    public void add(Dinner dinner) {
        dinnerRepository.save(dinner);
    }

    public void remove(Dinner dinner) {
        dinnerRepository.usun(dinner);
    }
}
