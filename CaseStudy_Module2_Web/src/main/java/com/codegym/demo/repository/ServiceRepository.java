package com.codegym.demo.repository;

import com.codegym.demo.model.Service;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    @Query("select s from Service s where s.serviceType.name like %?1%")
    Page<Service>findAllWhereNameBeLike(String name , Pageable pageable);
    Page<Service>findAllByStatus(String status,Pageable pageable);

}
