package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();
    Category findById(int id);
    void save(Category category);
    void deleteById(int id);
}
