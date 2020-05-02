package com.codegym.demo.service.impl;

import com.codegym.demo.model.Contract;
import com.codegym.demo.repository.ContractRepository;
import com.codegym.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepo;
    @Override
    public Page<Contract> findAll(Pageable pageable)
    {
        return contractRepo.findAll(pageable);
    }

    @Override
    public Contract findById(Long id)
    {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepo.findAll();
    }

    @Override
    public void save(Contract contract)
    {
        contractRepo.save(contract);
    }

    @Override
    public void remove(Long id)
    {
        contractRepo.deleteById(id);
    }
}
