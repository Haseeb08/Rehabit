package com.vikingzorros.rehabit.dto;

import com.vikingzorros.rehabit.entities.BlockUser;
import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private int id;

    @NotNull(message = "First Name is required")
    private String firstName;

    private String lastName;

    @NotNull(message = "User Name is required")
    @Size(min=4,max=20,message="Length - at least 4 and at most 20")
    @Pattern(regexp="^[a-zA-Z]+[a-zA-Z\\d]*([#_]?[a-zA-Z0-9]+)*$",message="Invalid user name")
    private String userName;

    @NotNull(message = "Email is required")
    private String email;

    @ToString.Exclude
    @NotNull(message = "Password is required")
    @Size(min=8,max=16,message = "Length - at least 8 and at most 16")
    @Pattern(regexp="^[\\w]+[@#$%^&*\\w]*$",message="Invalid Password")
    private String password;

    @NotNull(message = "Phone number is required")
    @Size(min=8,max=14)
    @Pattern(regexp = "^(\\+)?[0-9]+$",message = "Invalid phone number")
    private String phoneNumber;

    private String createTime;

    @ToString.Exclude
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Post> posts;
//
//    @ToString.Exclude
//    @ElementCollection(fetch = FetchType.LAZY)
//    private List<Comment> comments;
//
//    @ToString.Exclude
//    @ElementCollection(fetch = FetchType.LAZY)
//    private List<BlockUser> blockUserList;

}