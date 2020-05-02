package com.admin.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;
    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<Blog> getBlogs()
    {
        return this.blogs;
    }

    public void setBlogs(List<Blog> blogs)
    {
        this.blogs = blogs;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String name;
    public Category(){}
}
