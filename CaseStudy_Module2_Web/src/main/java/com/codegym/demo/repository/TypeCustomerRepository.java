package com.codegym.demo.repository;

import com.codegym.demo.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer,Long> {
    @Query("select tc from TypeCustomer tc")
    List<TypeCustomer> getAll();
}
