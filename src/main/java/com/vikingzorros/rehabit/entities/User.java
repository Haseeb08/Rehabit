package com.vikingzorros.rehabit.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
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

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="create_time")
    private String createTime;

    @OneToMany(cascade=CascadeType.ALL ,
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
    private List<BlockUser> blockUserList;

}
