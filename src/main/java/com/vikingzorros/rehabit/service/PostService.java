package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDto> findAllPosts();
    PostDto findById(int id);
    void save(PostDto post);
    void deleteById(int id);
    List<PostDto> findByCategory(Category category);


    List<PostDto> findAllByUserId(int id);

    List<PostDto> findAllPostsTracker(int id);
}
