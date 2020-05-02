package com.admin.app.formatter;

import com.admin.app.model.Category;
import com.admin.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category>
{
    @Autowired
    private CategoryService categoryService;
    @Override
    public Category parse(String text, Locale locale) throws ParseException
    {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale)
    {
        return null;
    }
}
