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
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "create_time")
    String createTime;

    @Column(name = "habit_count")
    int habitCount;

    @OneToMany(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Comment> commentList;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TrackHabit> trackHabitList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

}
