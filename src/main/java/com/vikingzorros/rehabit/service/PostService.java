package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<Post> findAllPosts();
    Post findById(int id);
    void save(Post post);
    void deleteById(int id);
    List<Post> findByCategory(Category category);

    List<Post> findAllByUserId(int id);
}
