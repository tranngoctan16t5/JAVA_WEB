package com.codegym.demo.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private String idCard;

    @ManyToOne(targetEntity = TypeCustomer.class)
    @JoinColumn(name = "type_customer_id")
    private TypeCustomer typeCustomer;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;
    public Customer() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        if(this.birthDay==null) return "";
        return new SimpleDateFormat("dd/MM/yyyy").format(this.birthDay);
    }

    public void setBirthDay(String birthDay) {
        try{
            this.birthDay=new SimpleDateFormat("yyyy-MM-dd").parse(birthDay);
        }catch (ParseException e){
            this.birthDay=null;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
