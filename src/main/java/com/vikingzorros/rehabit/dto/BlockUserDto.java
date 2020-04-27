package com.vikingzorros.rehabit.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlockUserDto {

    private int id;

    private int blockedUserId;

    private String createTime;

    private UserDto user;


}
