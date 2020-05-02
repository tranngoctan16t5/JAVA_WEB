package com.codegym.demo.repository;

import com.codegym.demo.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType,Long> {
    @Query("select rt from RentType  rt")
    List<RentType> findAll();
}
