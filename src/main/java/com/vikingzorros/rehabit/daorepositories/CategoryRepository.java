package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
