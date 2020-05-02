package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Part
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Part(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Employee> getEmployees()
    {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
