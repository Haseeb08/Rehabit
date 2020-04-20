package com.vikingzorros.rehabit.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,
    mappedBy = "user")
    private List<BlockUser> blockUserList;

    public User(String userName, String email, String password, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void addPost(Post tempPost) {

        if (posts == null) {
            posts = new ArrayList<>();
        }

        posts.add(tempPost);

        tempPost.setUser(this);
    }

    public void addComment(Comment tempComment) {

        if (comments == null) {
            comments = new ArrayList<>();
        }

        comments.add(tempComment);

        tempComment.setUser(this);
    }

    public void addBlockUser(BlockUser tempBlockUser) {

        if (blockUserList == null) {
            blockUserList = new ArrayList<>();
        }

        blockUserList.add(tempBlockUser);
    }

}
