package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="trash_post")
public class TrashPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "time")
    private String time;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "posts_id")
    private Post post;

}
