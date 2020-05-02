package com.admin.app.service.impl;

import com.admin.app.model.Blog;
import com.admin.app.model.Category;
import com.admin.app.repository.BlogRepository;
import com.admin.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BlogServiceImpl implements BlogService
{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable)
    {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id)
    {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog)
    {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id)
    {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByCategory(Pageable pageable, Category category)
    {
        return blogRepository.findAllByCategory(pageable, category);
    }

//    @Override
//    public Page<Blog> findAllOrderByDateCreatedDesc(Pageable pageable)
//    {
//        return blogRepository.findAllOrderByDateCreatedDesc(pageable);
//    }

//    @Override
//    public Iterable<Blog> findAllSortByDateCreated()
//    {
//        //Sort sort=new Sort(new Sort.Order(Sort.Direction.DESC,"dateCreated"));
//        return blogRepository.findAll(Sort.by(Sort.Direction.DESC,"dateCreated"));
//    }

    @Override
    public Page<Blog> findAllByContent(Pageable pageable, String content)
    {
        return blogRepository.findAllByContent(pageable,content);
    }

    @Override
    public Page<Blog> findAllThenOrderByDateCreated(Pageable pageable)
    {
        return blogRepository.findAllThenOrderByDateCreated(pageable);
    }

    @Override
    public Page<Blog> findAllWhereTitleBelike(Pageable pageable, String title)
    {
        return blogRepository.findAllWhereTitleBelike(pageable, title);
    }

}
