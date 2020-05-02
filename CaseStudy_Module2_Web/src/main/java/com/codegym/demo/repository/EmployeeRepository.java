package com.codegym.demo.repository;

import com.codegym.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    @Query("select e from Employee e where e.fullName like %?1%")
    Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable);

    @Query("select e from Employee e inner join Contract c on c.employee.id=e.id")
    Page<Employee> findEmployeesHaveContract(Pageable pageable);
}