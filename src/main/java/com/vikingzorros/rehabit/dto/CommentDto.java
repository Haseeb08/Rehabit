package com.vikingzorros.rehabit.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {

    private int id;

    private String message;

    private String createTime;

    private boolean status;

    private UserDto user;

    private PostDto post;

}
