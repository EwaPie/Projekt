package com.projekt.repository;

import com.projekt.model.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerRepository extends JpaRepository<Dinner, Integer> {
}
