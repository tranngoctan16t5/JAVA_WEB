package com.codegym.demo.validator;

import com.codegym.demo.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        final String email = customer.getEmail();
        final String phoneNumber = customer.getPhoneNumber();
        final String id = customer.getId();
        final String idCard = customer.getIdCard();
        ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "idCard", "idCard.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "birthDay", "birthDay.empty");
        if (!email.matches("^\\w+@{1}gmail\\.[a-z]+$")) {
            errors.rejectValue("email","email.matches");
        }
        if (!phoneNumber.matches("(^090[0-9]{7})|(091[0-9]{7})|(\\(84\\)\\+90[0-9]{7})|\\(84\\)\\+91[0-9]{7}")) {
            errors.rejectValue("phoneNumber","phoneNumber.matches");
        }
        if (!id.matches("KH-([0-9]{4})")) {
            errors.rejectValue("id","id.matches");
        }
        if (!idCard.matches("^[\\d]{9}$")) {
            errors.rejectValue("idCard","idCard.matches");
        }

    }
}
