package com.admin.app.service.impl;

import com.admin.app.model.Category;
import com.admin.app.repository.CategoryRepository;
import com.admin.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable)
    {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category)
    {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id)
    {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id)
    {
        categoryRepository.deleteById(id);
    }
}
