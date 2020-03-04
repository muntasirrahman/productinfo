package com.pensil.lab.productinfo.repository;

import com.pensil.lab.productinfo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIdIn(Collection<Long> ids);
}