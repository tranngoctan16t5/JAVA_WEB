package com.admin.app.service;

import com.admin.app.model.Category;
import com.admin.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService
{
    Page<Category> findAll(Pageable pageable);
    void save(Category category);
    Category findById(Long id);
    void remove(Long id);
}
