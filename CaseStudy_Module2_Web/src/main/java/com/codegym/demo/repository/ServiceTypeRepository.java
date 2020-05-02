package com.codegym.demo.repository;

import com.codegym.demo.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
    @Query("select st from ServiceType st")
    List<ServiceType> findAll();
}
