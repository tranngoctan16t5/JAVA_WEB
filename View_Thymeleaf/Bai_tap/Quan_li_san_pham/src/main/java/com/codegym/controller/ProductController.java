package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private ProductService productService=new ProductServiceImpl();

    @GetMapping("/")
     public String index(Model model)   {
        model.addAttribute("listproduct",productService.findAll());
        return "index";
    }
    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save( Product product, RedirectAttributes redirect){
         product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirect.addFlashAttribute("success","add product successly!!!");
        return "redirect:/";

    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView editForm(@PathVariable("id") int id){
          Product product=productService.findById(id);
          ModelAndView modelAndView=new ModelAndView("/edit");
          modelAndView.addObject("product",product);
          return modelAndView;
    }
    @PostMapping("/product/update")
        public ModelAndView editProduct(@ModelAttribute Product product){
        productService.save(product);
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("product",product);
        modelAndView.addObject("message","Edit successfully !!!");
        return  modelAndView;

    }
    @GetMapping("product/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id){
        productService.remove(id);
        return "redirect:/";
    }
}
