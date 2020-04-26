package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.CategoryRepository;
import com.vikingzorros.rehabit.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {


        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(int id) {

    }
}
