package com.admin.app.controller;

import com.admin.app.model.Blog;
import com.admin.app.service.BlogService;
import com.admin.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController
{
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/blog-search")
    public ModelAndView search(@PageableDefault(value = 3) Pageable pageable, @RequestParam String search,RedirectAttributes redirectAttributes)
    {

        Page<Blog> blogs=blogService.findAllWhereTitleBelike(pageable,search);
        return new ModelAndView("/blog/blog","blogs",blogs);
    }
    @GetMapping("/blogs")
    public String blogs(Model model, @PageableDefault(value = 3)Pageable pageable){
        model.addAttribute("blogs",
                blogService.findAll(pageable));
        return "/blog/blog";
    }
    @GetMapping("/blog-edit/{id}")
    public ModelAndView edit(Model model,@PathVariable long id,Pageable pageable){
        ModelAndView mav=new ModelAndView(
                "/blog/edit","blog",blogService.findById(id)
        );
        mav.addObject("categories",categoryService.findAll(pageable));
        return mav;
    }
    @PostMapping("/blog-edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes)
    {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("status","edit oke");
        return "redirect:/blogs";
    }
    @GetMapping("/blog-create")
    public ModelAndView create(Pageable pageable){
        ModelAndView mav=new ModelAndView(
                "/blog/create","blog",new Blog()
        );
        mav.addObject("categories",categoryService.findAll(pageable));
        return mav;
    }
    @PostMapping("/blog-create")
    public String create(Blog blog,RedirectAttributes rA){
        blogService.save(blog);
        rA.addFlashAttribute("status","create oke");
        return "redirect:/blogs";
    }
    @GetMapping("/blog-sort")
    public ModelAndView sort(Pageable pageable){
        return new ModelAndView(
                "/blog/blog","blogs",
                blogService.findAllThenOrderByDateCreated(pageable)
        );
    }
}
