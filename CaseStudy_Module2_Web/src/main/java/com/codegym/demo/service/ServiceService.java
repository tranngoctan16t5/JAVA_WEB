package com.codegym.demo.service;

import com.codegym.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    Page<Service> findAllWhereNameBeLike(String name, Pageable pageable);

    Page<Service> findAllByStatus(String status,Pageable pageable);

    Service findById(Long id);

    void save(Service service);

    void remove(Long id);





}
