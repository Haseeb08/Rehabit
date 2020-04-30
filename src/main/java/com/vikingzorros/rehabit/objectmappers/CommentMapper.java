package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.CommentDto;
import com.vikingzorros.rehabit.entities.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CommentMapper {


    @Autowired
    private ModelMapper modelMapper;

    public CommentDto convertToDto(Comment comment) {
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);

        return commentDto;
    }

    public Comment convertToEntity(CommentDto theCommentDto) {
        Comment comment = modelMapper.map(theCommentDto, Comment.class);
        return comment;
    }

    public List<CommentDto> convertToDtos(Collection<Comment> comments) {
        return comments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public final List<Comment> convertToEntities(final Collection<CommentDto> commentDtos) {
        return commentDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}