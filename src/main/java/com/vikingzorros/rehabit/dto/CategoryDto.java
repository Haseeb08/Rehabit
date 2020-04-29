package com.vikingzorros.rehabit.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto {

    private int id;

    private String name;

    private String description;

    private List<MotivationalMessageDto> messageList;

    private List<PostDto> posts;

}
