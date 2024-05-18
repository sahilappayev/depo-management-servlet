package com.example.depomanagementservlet.service;

import com.example.depomanagementservlet.dto.CategoryResponseDto;
import com.example.depomanagementservlet.entity.Category;
import com.example.depomanagementservlet.exception.CustomNotFoundException;
import com.example.depomanagementservlet.mapper.CategoryMapper;
import com.example.depomanagementservlet.repository.CategoryRepo;
import java.util.List;

public class CategoryService {

    private final CategoryRepo categoryRepo = new CategoryRepo();
    private final CategoryMapper categoryMapper = new CategoryMapper();


    public CategoryResponseDto create(String name) {
        Category category = categoryMapper.toEntity(name);
        Category created = categoryRepo.create(category);
        return categoryMapper.toResponseDto(created);
    }


    public CategoryResponseDto update(Integer id, String name) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException(Category.class, id));
        category.setName(name);

        Category updated = categoryRepo.update(category);

        return categoryMapper.toResponseDto(updated);
    }

    public CategoryResponseDto getById(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException(Category.class, id));
        return categoryMapper.toResponseDto(category);
    }

    public List<CategoryResponseDto> getAll() {
        List<Category> all = categoryRepo.findAll();
        return all.stream().map(categoryMapper::toResponseDto).toList();
    }

    public CategoryResponseDto delete(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException(Category.class, id));
        Category deleted = categoryRepo.delete(category);
        return categoryMapper.toResponseDto(deleted);
    }

}
