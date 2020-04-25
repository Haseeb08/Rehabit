package com.vikingzorros.rehabit.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotificationDto {


    private int id;


    private String message;


    private boolean status;


    private String time;

    private TrackHabitDto trackHabit;

}
