package com.vikingzorros.rehabit.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MotivationalMessageDto {

    private int id;

    private String message;

    private CategoryDto category;

}
