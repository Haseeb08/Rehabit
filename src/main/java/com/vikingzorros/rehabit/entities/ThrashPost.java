package com.vikingzorros.rehabit.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trash_post")
public class ThrashPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "time")
    private String time;

    // postId

    @OneToOne
    @JoinColumn(name = "posts_id")
    private Post post;

    public ThrashPost(int id) {
        this.id = id;
    }
}
