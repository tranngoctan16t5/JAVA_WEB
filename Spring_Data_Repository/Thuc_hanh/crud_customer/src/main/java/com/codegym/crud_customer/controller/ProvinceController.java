package com.codegym.crud_customer.controller;

import com.codegym.crud_customer.model.Customer;
import com.codegym.crud_customer.model.Province;
import com.codegym.crud_customer.service.CustomerService;
import com.codegym.crud_customer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CustomerService customerService;
    @GetMapping("/provinces")
    public ModelAndView listProvinces(){
        Iterable<Province> provinces=provinceService.findAll();
        ModelAndView modelAndView=new ModelAndView("/province/list");
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }
    @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/province/create");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
    @PostMapping("/create-province")
    public ModelAndView createProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView=new ModelAndView("/province/create");
        modelAndView.addObject("province",province);
        modelAndView.addObject("message","Create province successfully!!!");
        return modelAndView;
    }
    @GetMapping("/edit-province/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Province province= provinceService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/province/edit");
        modelAndView.addObject("province",province);
        return modelAndView;
    }
    @PostMapping("/edit-province")
    public ModelAndView editProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView=new ModelAndView("/province/edit");
        modelAndView.addObject("message","Edit province successfully!!");
        modelAndView.addObject("province",province);
        return modelAndView;
    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Province province=provinceService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/province/delete");
        modelAndView.addObject("province",province);
        return modelAndView;
    }
    @PostMapping("/delete-province")
    public ModelAndView deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        ModelAndView modelAndView=new ModelAndView("/province/delete");
        modelAndView.addObject("message","Province deleted successfully!!!");
        modelAndView.addObject("province",province);
        return modelAndView;
    }
    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Province province = provinceService.findById(id);
        if(province == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(province);

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}


