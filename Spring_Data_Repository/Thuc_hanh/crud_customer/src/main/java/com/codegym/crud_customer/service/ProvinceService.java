package com.codegym.crud_customer.service;

import com.codegym.crud_customer.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();
    Province findById(Long id);
    void save(Province province);
    void remove(Long id);
}
