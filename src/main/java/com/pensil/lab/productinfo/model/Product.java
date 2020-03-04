package com.pensil.lab.productinfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private long id;

    private String name;

    private int quantity;

    @Column(name = "sale_amount")
    @JsonProperty("sale_amount")
    private double saleAmount;

    public Product() {
    }

    public Product(long id) {
        this.id = id;
    }

    public Product(long id, String name, int quantity, double saleAmount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.saleAmount = saleAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 127 * hash + (int) id;
        hash = 127 * hash + name.hashCode();
        hash = 127 * hash + quantity;
        hash = 127 * hash + (int) saleAmount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if (obj instanceof Product) {
            return hashCode() == obj.hashCode();
        }
        return false;
    }
}
