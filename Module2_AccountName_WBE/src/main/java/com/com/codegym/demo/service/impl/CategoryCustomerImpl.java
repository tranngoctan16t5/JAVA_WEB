package com.com.codegym.demo.service.impl;

import com.com.codegym.demo.model.CategoryCustomer;
import com.com.codegym.demo.repository.CategoryCustomerRepository;
import com.com.codegym.demo.service.CategoryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCustomerImpl implements CategoryCustomerService {
    @Autowired
    private CategoryCustomerRepository categoryCustomerRepository;
    @Override
    public Iterable<CategoryCustomer> findAll() {
        return categoryCustomerRepository.findAll();
    }

    @Override
    public CategoryCustomer findById(Long id) {
        return categoryCustomerRepository.findById(id).get();
    }

    @Override
    public void save(CategoryCustomer categoryCustomer) {
        categoryCustomerRepository.save(categoryCustomer);

    }

    @Override
    public void remove(Long id) {
        categoryCustomerRepository.deleteById(id);

    }
}
