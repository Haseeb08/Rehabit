package com.vikingzorros.rehabit.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrackHabitDto {


   private int id;

    private String notifyTime;

    private String response;

    private NotificationDto notification;

    private PostDto post;

}
