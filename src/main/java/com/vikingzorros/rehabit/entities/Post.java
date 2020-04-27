package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "is_anonymous")
    private int isAnonymous;

    @Column(name = "habit_count")
    private int habitCount;

    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post")
    private List<Comment> commentList;

    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TrackHabit> trackHabitList;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
