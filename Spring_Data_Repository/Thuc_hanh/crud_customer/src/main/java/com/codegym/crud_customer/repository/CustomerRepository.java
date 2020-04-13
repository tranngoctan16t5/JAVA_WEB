package com.codegym.crud_customer.repository;

import com.codegym.crud_customer.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
