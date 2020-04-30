package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.TrashPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashPostRepository extends JpaRepository<TrashPost,Integer> {
}
