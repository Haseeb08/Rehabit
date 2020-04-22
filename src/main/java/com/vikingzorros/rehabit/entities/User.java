package com.vikingzorros.rehabit.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @ToString.Exclude
    @Column(name="password")
    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="create_time")
    private String createTime;

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Post> posts;

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Comment> comments;

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<BlockUser> blockUserList;

}
