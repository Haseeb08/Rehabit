package com.vikingzorros.rehabit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int id;

    private String title;

    private String description;

    private String createTime;

    private int isAnonymous;

    private int habitCount;

    private List<CommentDto> commentList;

    private UserDto user;

    private List<TrackHabitDto> trackHabitList;

    private CategoryDto category;


}
