package com.codegym.demo.service.impl;

import com.codegym.demo.model.Service;
import com.codegym.demo.repository.ServiceRepository;
import com.codegym.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findAllWhereNameBeLike(String name, Pageable pageable) {
        return serviceRepository.findAllWhereNameBeLike(name,pageable);
    }

    @Override
    public Page<Service> findAllByStatus(String status, Pageable pageable) {
        return serviceRepository.findAllByStatus(status,pageable);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
       serviceRepository.deleteById(id);
    }


}
