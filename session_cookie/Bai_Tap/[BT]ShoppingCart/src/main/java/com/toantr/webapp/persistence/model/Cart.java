package com.toantr.webapp.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
    private List<Product> shoppingCart;

    public Cart(){
        this.shoppingCart=new ArrayList<>();
    }
    public List<Product> findAll(){
        return this.shoppingCart;
    }
    public void addProduct(Product product){
        shoppingCart.add(product);
    }
    public void removeProduct(Long id){
        shoppingCart.removeIf(p -> p.getId() == id);
    }
}
