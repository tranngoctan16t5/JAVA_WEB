package com.admin.app.service;

import com.admin.app.model.Blog;
import com.admin.app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BlogService
{
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Page<Blog> findAllByCategory(Pageable pageable,Category category);
//    Page<Blog> findAllOrderByDateCreatedDesc(Pageable pageable);
//    Iterable<Blog> findAllSortByDateCreated();
    Page<Blog> findAllByContent(Pageable pageable,String content);
    Page<Blog> findAllThenOrderByDateCreated(Pageable pageable);
    Page<Blog> findAllWhereTitleBelike(Pageable pageable,String title);
}
