package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.CommentDto;
import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAllComments();
    CommentDto findById(int id);
    void save(CommentDto comment);
    void deleteById(int id);
    List<CommentDto> findByPost(PostDto post);
}
