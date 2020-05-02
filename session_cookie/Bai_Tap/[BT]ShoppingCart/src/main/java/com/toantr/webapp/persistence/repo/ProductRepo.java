package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long>
{
}
