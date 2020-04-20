package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByPost_id(int theId);
   // List<Comment> findByPost_idOrderByCreate_timeDesc(int theId);
}
