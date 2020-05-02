package com.com.codegym.demo.controller;

import com.com.codegym.demo.model.CategoryCustomer;
import com.com.codegym.demo.model.Customer;
import com.com.codegym.demo.service.CategoryCustomerService;
import com.com.codegym.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CategoryCustomerService categoryCustomerService;

    @ModelAttribute("category_customer")
    public Iterable<CategoryCustomer> categories() {
        return categoryCustomerService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/layout");
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showFormCustomer() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        new Customer().validate(customer, bindingResult);
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
           modelAndView=new ModelAndView("/create");
        }else{
            customerService.save(customer);
            modelAndView = new ModelAndView("/create");
            modelAndView.addObject("message", "Create customer successfully!!!");

        }
        return modelAndView;

    }

    @GetMapping("/list-customer")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findAllByNameContaining(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list_customer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("edit-customer/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") String id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;

    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("message", "Edit Customer Successfully !!!");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public String deteteCustomr(@PathVariable("id") String id) {
        customerService.remove(id);
        return "redirect:/list-customer";
    }

}
