package com.codegym.demo.service;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product find(int id);
}
