package com.toantr.webapp.persistence.service;

import com.toantr.webapp.persistence.model.Product;

public interface ProductService
{
    Iterable<Product> findAll();
    void save(Product product);
    Product findById(Long id);
}
