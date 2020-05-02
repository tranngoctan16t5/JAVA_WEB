package com.com.codegym.demo.repository;

import com.com.codegym.demo.model.CategoryCustomer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryCustomerRepository extends PagingAndSortingRepository<CategoryCustomer,Long> {
}
