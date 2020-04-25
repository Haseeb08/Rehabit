package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="motivation_message")
public class MotivationalMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private int id;

    @Column(name="message")
    private String message;

    @ToString.Exclude
    @ManyToOne(cascade=CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
