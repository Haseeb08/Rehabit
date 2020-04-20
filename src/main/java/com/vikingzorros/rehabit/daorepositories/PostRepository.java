package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

        List<Post> findByCategory_id(int theId);
       //  List<Post> findByCategory_idOrderByCreate_timeDesc(int theId);

}
