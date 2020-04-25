package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> findAllPosts();
    Post findById(int id);
    void save(Post post);
    void deleteById(int id);
    List<Post> findByCategory(Category category);
}
