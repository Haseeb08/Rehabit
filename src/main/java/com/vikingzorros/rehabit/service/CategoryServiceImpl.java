package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.CategoryRepository;
import com.vikingzorros.rehabit.dto.CategoryDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.objectmappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories =categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = categoryMapper.convertToDtos(categories);
        return  categoryDtoList;
    }

    @Override
    public CategoryDto findById(int id) {

        return null;
    }

    @Override
    public void save(CategoryDto categoryDto) {

    Category category = categoryMapper.convertToEntity(categoryDto);
    categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {

    }

    public CategoryDto findByName(String name){

        Category category =categoryRepository.findByName(name);
        CategoryDto categoryDto = categoryMapper.convertToDto(category);
        return categoryDto;
    }
}
