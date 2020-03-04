package com.pensil.lab.productinfo.service;

import com.pensil.lab.productinfo.model.Product;
import com.pensil.lab.productinfo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductById(List<Long> ids) {
        return productRepository.findByIdIn(ids);
    }

    public List<Product> addProducts(List<Product> productList) {
        return productRepository.saveAll(productList);
    }
}