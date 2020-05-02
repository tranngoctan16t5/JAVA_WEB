package com.toantr.webapp.validation;

import com.toantr.webapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
/*
        Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự

        Phonenumber đúng quy tắc của sđt

        Age >=18

        Email đúng quy tắc của email
*/
        User user=(User)target;
        final String firstName=user.getFirstName();
        final String lastName=user.getLastName();
        final String phoneNumber=user.getPhoneNumber();
        final int age=user.getAge();
        final String email=user.getEmail();
        if(!(firstName.length()>=5&&firstName.length()<=45)){
            errors.rejectValue("firstName","user.firstName.length",
                    "First name must between 5 and 45 chars");
        }
        if(!(lastName.length()>=5&&lastName.length()<=45)){
            errors.rejectValue("lastName","user.lastName.length",
                    "Last name must between 5 and 45 chars");
        }
        if(phoneNumber.length()!=0&&!phoneNumber.matches("^[0][\\d]{9,10}$")){
            errors.rejectValue("phoneNumber","user.phoneNumber.invalid",
                    "Invalid phone number");
        }
        if(!(age>=18)){
            errors.rejectValue("age","user.age.toSmall","You're under 18, pls comeback" +
                    "few years later!");
        }
        if(email.matches("^[\\w][\\w\\d]{2,8}@[\\w]{3,5}\\.[\\w]{3,7}")){
            errors.rejectValue("email","user.email.invalid","Invalid email");
        }
    }
}
