package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    private Date birth;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private long salary;
    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne(targetEntity = Part.class)
    @JoinColumn(name="part_id")
    private Part part;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;

    public Employee(){}

    public List<Contract> getContractList()
    {
        return this.contractList;
    }

    public void setContractList(List<Contract> contractList)
    {
        this.contractList = contractList;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return this.fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public Date getBirth()
    {
        return this.birth;
    }

    public void setBirth(Date birth)
    {
        this.birth = birth;
    }

    public String getIdNumber()
    {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Degree getDegree()
    {
        return this.degree;
    }

    public void setDegree(Degree degree)
    {
        this.degree = degree;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public Part getPar()
    {
        return this.part;
    }

    public void setPar(Part part)
    {
        this.part = part;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Part getPart()
    {
        return this.part;
    }

    public void setPart(Part part)
    {
        this.part = part;
    }

    public long getSalary()
    {
        return this.salary;
    }

    public void setSalary(long salary)
    {
        this.salary = salary;
    }
}