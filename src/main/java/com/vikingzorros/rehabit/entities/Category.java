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
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

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

}
