package com.com.codegym.demo.service;

import com.com.codegym.demo.model.CategoryCustomer;


public interface CategoryCustomerService {
    Iterable<CategoryCustomer> findAll();

    CategoryCustomer findById(Long id);

    void save(CategoryCustomer categoryCustomer);

    void remove(Long id);
}
