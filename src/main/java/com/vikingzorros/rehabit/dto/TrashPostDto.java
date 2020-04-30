package com.vikingzorros.rehabit.dto;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrashPostDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "time")
    private String time;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "posts_id")
    private PostDto post;

}
