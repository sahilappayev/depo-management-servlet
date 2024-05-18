package com.example.depomanagementservlet.mapper;

import com.example.depomanagementservlet.dto.CategoryResponseDto;
import com.example.depomanagementservlet.entity.Category;

public class CategoryMapper {

    public Category toEntity(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }

    public CategoryResponseDto toResponseDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        return categoryResponseDto;
    }


}
