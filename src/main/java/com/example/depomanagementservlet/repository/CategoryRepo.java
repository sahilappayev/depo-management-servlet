package com.example.depomanagementservlet.repository;

import com.example.depomanagementservlet.entity.Category;

public class CategoryRepo extends AbstractCrudRepository<Category, Integer> {
    public CategoryRepo() {
        super(Category.class);
    }
}
