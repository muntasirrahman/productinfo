package com.pensil.lab.productinfo;

import com.pensil.lab.productinfo.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductsEvent {

    private long id = System.currentTimeMillis();
    private Date timestamp = new Date();
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products == null) products = new ArrayList<>();
        products.add(product);
    }
}
