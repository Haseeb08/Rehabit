package com.vikingzorros.rehabit.dto;


import com.vikingzorros.rehabit.entities.User;
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

    private boolean isAnonymous;

    private int habitCount;

    private List<CommentDto> commentList;

    private User user;

    private List<TrackHabitDto> trackHabitList;

    private CategoryDto category;

}
