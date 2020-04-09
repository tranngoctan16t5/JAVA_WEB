package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> listProduct;

    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"iphone 10",18000000, "/img/iphone10.jpg","China"));
        listProduct.put(2,new Product(2,"Sam Sung A71",15000000, "/imageWeb/img/samsunga71.jpg","Korea"));
        listProduct.put(3,new Product(3,"Oppo A91",8000000, "/imageWeb/img/oppoa91.jpg","Taiwan"));
        listProduct.put(4,new Product(4,"Xiaomi 10",9000000, "/imageWeb/img/xiaomi10.jpg","China"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id,product);

    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);

    }
}
