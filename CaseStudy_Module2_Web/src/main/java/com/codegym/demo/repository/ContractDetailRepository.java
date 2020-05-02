package com.codegym.demo.repository;

import com.codegym.demo.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    @Query("select cd from ContractDetail cd")
    List<ContractDetail> findAll();
}
