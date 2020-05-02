package com.codegym.demo.repository;

import com.codegym.demo.model.AccompanyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccompanyServiceRepository extends JpaRepository<AccompanyService,Long> {
    @Query("select aser from AccompanyService aser")
    List<AccompanyService> myFindAll();
}
