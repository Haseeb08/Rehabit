package com.vikingzorros.rehabit.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private List<MotivationalMessage> messageList;

    @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Post> posts;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addMotivationalMessage(MotivationalMessage tempMotivationalMessage) {

        if (messageList == null) {
            messageList = new ArrayList<>();
        }

        messageList.add(tempMotivationalMessage);
    }

    public void addPost(Post tempPost) {

        if (posts == null) {
            posts = new ArrayList<>();
        }

        posts.add(tempPost);

        tempPost.setCategory(this);
    }
}
