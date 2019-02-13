package com.projekt.repository;

import com.projekt.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {

}
