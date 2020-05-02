package com.com.codegym.demo.repository;

import com.com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,String> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
