package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.CategoryDto;
import com.vikingzorros.rehabit.dto.CategoryDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {


    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);

        return categoryDto;
    }

    public Category convertToEntity(CategoryDto theCategoryDto) {
        Category Category = modelMapper.map(theCategoryDto, Category.class);
        return Category;
    }

    public List<CategoryDto> convertToDtos(Collection<Category> Categorys) {
        return Categorys.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public final List<Category> convertToEntities(final Collection<CategoryDto> CategoryDtos) {
        return CategoryDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
