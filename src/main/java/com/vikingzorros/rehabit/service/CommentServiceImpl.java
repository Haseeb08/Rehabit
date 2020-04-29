package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.CommentRepository;
import com.vikingzorros.rehabit.dto.CommentDto;
import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.objectmappers.CommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements  CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<CommentDto> findAllComments() {

        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = commentMapper.convertToDtos(commentList);
        log.info("Comments : {}",commentDtoList.get(0));
        return commentDtoList;
    }

    @Override
    public CommentDto findById(int id) {
        return null;
    }

    @Override
    public void save(CommentDto commentDto) {
        Comment comment= commentMapper.convertToEntity(commentDto);
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Comment> findByPost(PostDto post) {
        List<Comment> commentList = commentRepository.findByPostId(post.getId());
        //List<CommentDto> commentDtoList = commentMapper.convertToDtos(commentList);

        return commentList;
    }
}
