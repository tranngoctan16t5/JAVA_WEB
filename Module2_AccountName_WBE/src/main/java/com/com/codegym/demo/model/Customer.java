package com.com.codegym.demo.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.persistence.*;


@Component
@Entity
@Table(name = "khach_hang")
public class Customer implements Validator {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "ho_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private String birthDay;
    @Column(name = "so_cmnd")
    private String idCard;
    @Column(name = "sdt")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "dia_chi")
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_loai_khach")
    private CategoryCustomer categoryCustomer;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CategoryCustomer getCategoryCustomer() {
        return categoryCustomer;
    }

    public void setCategoryCustomer(CategoryCustomer categoryCustomer) {
        this.categoryCustomer = categoryCustomer;
    }


    @Override
    public boolean supports(Class<?> clazz) {
          return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
         Customer customer=(Customer) target;
         String id=customer.getId();
         String phoneNumber=customer.getPhoneNumber();
         String idCard=customer.getIdCard();
         String email=customer.getEmail();
         String birthDay = customer.getBirthDay();
         ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
         ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
         ValidationUtils.rejectIfEmpty(errors, "idCard", "idCard.empty");
         ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
         ValidationUtils.rejectIfEmpty(errors, "birthDay", "birthDay.empty");
         if(!id.matches("KH-([0-9]{4})")){
             errors.rejectValue("id","id.matches");
        }
         if(!phoneNumber.matches("(^090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|\\(84\\)\\+91[0-9]{7}")){
             errors.rejectValue("phoneNumber","phoneNumber.matches");
         }
         if(!idCard.matches("([0-9]{9})|([0-9]{12})")){
             errors.rejectValue("idCard","idCard.matches");
         }
         if(!email.matches("^\\w+@{1}gmail\\.[a-z]+$")){
             errors.rejectValue("email","email.matches");
         }
         if(!birthDay.matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/((199[0-9])|(20[0-1][0-9]|2020))$")){
             errors.rejectValue("birthDay","birthDay.matches");
         }

    }
}
