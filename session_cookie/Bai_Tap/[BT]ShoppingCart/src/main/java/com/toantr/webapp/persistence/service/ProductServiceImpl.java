package com.toantr.webapp.persistence.service;

import com.toantr.webapp.persistence.model.Product;
import com.toantr.webapp.persistence.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Iterable<Product> findAll()
    {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product)
    {
        productRepo.save(product);
    }

    @Override
    public Product findById(Long id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
