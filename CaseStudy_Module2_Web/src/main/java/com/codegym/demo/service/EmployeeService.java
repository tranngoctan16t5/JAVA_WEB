package com.codegym.demo.service;

import com.codegym.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService  {
    Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable);
    Page<Employee> findEmployeesHaveContract(Pageable pageable);

    void save(Employee employee);
    void remove(Long id);
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
}
