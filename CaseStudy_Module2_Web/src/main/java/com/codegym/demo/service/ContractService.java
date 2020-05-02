package com.codegym.demo.service;

import com.codegym.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Long id);
    List<Contract>findAll();

    void save(Contract contract);
    void remove(Long id);
}
