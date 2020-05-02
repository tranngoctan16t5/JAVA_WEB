package com.toantr.webapp.controller;

import com.toantr.webapp.model.User;
import com.toantr.webapp.service.UserService;
import com.toantr.webapp.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users",userService.findAll());
        return "users";
    }
    @GetMapping("/users/register")
    public ModelAndView register(){
        return new ModelAndView("register","user",new User());
    }
    @PostMapping("/users")
    public String users(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes){
        new UserValidation().validate(user,result);
        if (result.hasFieldErrors()) {
            return "register";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("status","Register oke");
        return "redirect:/users";
    }
}
