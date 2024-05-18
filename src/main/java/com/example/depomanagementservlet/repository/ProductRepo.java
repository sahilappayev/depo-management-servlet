package com.example.depomanagementservlet.repository;

import com.example.depomanagementservlet.entity.Product;

public class ProductRepo extends AbstractCrudRepository<Product, Integer> {
    public ProductRepo() {
        super(Product.class);
    }
}
