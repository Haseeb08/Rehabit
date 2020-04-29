package com.vikingzorros.rehabit.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Column(name="user_name")
    private String userName;

    @NotNull(message = "is required")
    @Column(name="firstName")
    private String firstName;

    @NotNull(message = "is required")
    @Column(name="lastName")
    private String lastName;

    @NotNull(message = "is required")
    @Column(name="email")
    private String email;

    @NotNull(message = "is required")
    @Column(name="password")
    private String password;

    @NotNull(message = "is required")
    @Column(name="phone_number")
    private String phoneNumber;


    @Column(name="create_time")
    private String createTime;

    /* @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<BlockUser> blockUserList; */

}