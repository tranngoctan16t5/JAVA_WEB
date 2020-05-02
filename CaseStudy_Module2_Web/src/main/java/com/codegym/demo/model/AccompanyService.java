package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accompany_service")
public class AccompanyService
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accompany_service_id")
    private Long id;

    private String name;
    private String currency;
    private long price;

    @OneToMany(targetEntity = ContractDetail.class)
    private List<ContractDetail> contractDetails;

    public AccompanyService(){}

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

    public String getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public long getPrice()
    {
        return this.price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    public List<ContractDetail> getContractDetails()
    {
        return this.contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails)
    {
        this.contractDetails = contractDetails;
    }
}
