package com.toantr.webapp.controller;

import com.toantr.webapp.persistence.model.Cart;
import com.toantr.webapp.persistence.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes(names = {"cart","proGroup","count"})
public class ProductController
{
    @Autowired
    private ProductService productService;
    @ModelAttribute(name = "cart")
    public Cart getCart(){
        return new Cart();
    }
    @ModelAttribute(name="count")
    public int getCount(){
        return 0;
    }

    @ModelAttribute(name = "proGroup")
    public Map<Long,Integer> proGroup(){
        return new HashMap<>();
    }
    @GetMapping("/product-list")
    public String productList(Model model,@ModelAttribute("count")int count)
    {
        model.addAttribute("products",productService.findAll());
        model.addAttribute("count",count);
        return "products";
    }
    @GetMapping("/product-buy")
    public String buy(@RequestParam long id, @ModelAttribute("cart")Cart cart,
                      @ModelAttribute("proGroup")Map<Long,Integer> proGroup,
                      @ModelAttribute("count")int count,
                      RedirectAttributes redirectAttributes)
    {
        count++;
        System.out.println(count);
        if(proGroup.containsKey(id)){
            int newValue=proGroup.get(id);
            proGroup.replace(id,++newValue);
        }else{
            cart.addProduct(productService.findById(id));
            proGroup.put(id,1);
        }
        redirectAttributes.addFlashAttribute("count",count);
        return "redirect:/product-list";
    }
    @GetMapping("/cart")
    public String cart(Model model,@ModelAttribute("cart") Cart cart,
                       @ModelAttribute("proGroup")Map<Long,Integer> proGroup,
                       @ModelAttribute("count")int count)
    {
        model.addAttribute("products",cart.findAll());
        return "cart";
    }
    @GetMapping("/cart/{id}")
    public String cart(@PathVariable long id,
                       @ModelAttribute("proGroup")Map<Long,Integer> proGroup,
                       @RequestParam String action,
                       @ModelAttribute("count") int count,
                       RedirectAttributes redirectAttributes,
                       @ModelAttribute("cart")Cart cart)
    {
        int newValue=proGroup.get(id);
        switch (action){
            case "decrease":
                proGroup.replace(id,--newValue);
                count--;
                if(newValue==0){
                    cart.removeProduct(id);
                }
                break;
            case "increase":
                proGroup.replace(id,++newValue);
                count++;
                break;
        }
        redirectAttributes.addFlashAttribute("count",count);
        return "redirect:/cart";
    }

}
