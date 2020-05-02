package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Position(){}

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
