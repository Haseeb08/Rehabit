package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;

import java.util.List;

public interface CommentService {
    List<Comment> findAllComments();
    Comment findById(int id);
    void save(Comment comment);
    void deleteById(int id);
    List<Comment> findByPost(Post post);
}
