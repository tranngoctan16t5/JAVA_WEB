package com.admin.app.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "blog_v2")
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date dateCreated;

    public Date getDateCreated()
    {
        return this.dateCreated;
    }

    public void setDateCreated(String dateCreated) throws ParseException
    {
        DateFormat dateFormat=
                new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date=(Date)dateFormat.parse(dateCreated);
        this.dateCreated=date;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    private String content;
    private String title;

    public Blog(){}
}
