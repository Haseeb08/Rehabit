package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<MotivationalMessage> messageList;

    @ToString.Exclude
    @OneToMany(cascade=CascadeType.ALL ,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Post> posts;

}
