package com.codegym.demo.service.impl;

import com.codegym.demo.model.Employee;
import com.codegym.demo.repository.EmployeeRepository;
import com.codegym.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable) {
        return employeeRepository.findAllWhereNameBeLike(name, pageable);
    }

    @Override
    public Page<Employee> findEmployeesHaveContract(Pageable pageable) {
        return employeeRepository.findEmployeesHaveContract(pageable);
    }

    @Override

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public void remove(Long id)
    {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable)
    {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }
}
