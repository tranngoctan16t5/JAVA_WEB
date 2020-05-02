package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    void remove(String id);

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByFullName(String name,Pageable pageable);

    Customer findById(String id);

    Page<Customer> findCustomersUsingService(Pageable pageable);


}
