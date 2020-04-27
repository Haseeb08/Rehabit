package com.vikingzorros.rehabit.dto;

import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.User;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class CommentDto {

    private int id;

    private String message;

    private String createTime;

    private boolean status;

    private UserDto user;

    private PostDto post;

}
