package com.admin.app.controller;

import com.admin.app.model.Category;
import com.admin.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public String categories(Model model, @PageableDefault(value = 3)Pageable pageable)
    {
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "/category/category";
    }
    @GetMapping("/category-create")
    public ModelAndView create()
    {
        return new ModelAndView("/category/create","category",new Category());
    }
    @PostMapping("/category-create")
    public String create(Category category, RedirectAttributes redirectAttributes)
    {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("status","create oke");
        return "redirect:/categories";
    }
}
