package com.codegym.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;

    @ManyToOne(targetEntity = Contract.class,cascade = CascadeType.ALL)
    @JoinColumn(name="contract_id")
    private Contract contract;

    @ManyToOne(targetEntity = AccompanyService.class)
    @JoinColumn(name = "accompany_service_id")
    private AccompanyService accompanyService;

    private int quantity;

    public ContractDetail(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Contract getContract()
    {
        return this.contract;
    }

    public void setContract(Contract contract)
    {
        this.contract = contract;
    }

    public AccompanyService getAccompanyService()
    {
        return this.accompanyService;
    }

    public void setAccompanyService(AccompanyService accompanyService)
    {
        this.accompanyService = accompanyService;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
