package com.com.codegym.demo.formatter;

import com.com.codegym.demo.model.CategoryCustomer;
import com.com.codegym.demo.service.CategoryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryCustomerFormatter implements Formatter<CategoryCustomer> {
     private CategoryCustomerService categoryCustomerService;
     @Autowired
    public CategoryCustomerFormatter(CategoryCustomerService categoryCustomerService){
         this.categoryCustomerService=categoryCustomerService;
     }
    @Override
    public CategoryCustomer parse(String text, Locale locale) throws ParseException {
        return categoryCustomerService.findById(Long.parseLong(text));
    }

    @Override
    public String print(CategoryCustomer object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
