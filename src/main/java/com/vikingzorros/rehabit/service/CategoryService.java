package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.CategoryDto;
import com.vikingzorros.rehabit.entities.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAllCategories();
    CategoryDto findById(int id);
    void save(CategoryDto category);
    void deleteById(int id);
    CategoryDto findByName(String name);
}
