package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

        List<Post> findByCategoryId(int theId);

    List<Post> findAllByUserId(int id);


}
