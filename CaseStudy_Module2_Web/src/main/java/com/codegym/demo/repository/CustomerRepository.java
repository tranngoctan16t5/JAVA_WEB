package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query("select c from Customer c where c.fullName like %?1%")
    Page<Customer> findByFullName(String name, Pageable pageable);
    @Query("select c from Customer c inner join Contract con on c.id=con.customer.id")
    Page<Customer> findCustomersUsingService(Pageable pageable);
}
