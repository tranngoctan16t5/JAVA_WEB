package com.codegym.demo.dao;

import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product,Integer> {
}
