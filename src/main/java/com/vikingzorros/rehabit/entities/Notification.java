package com.vikingzorros.rehabit.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="message")
    private String message;

    @Column(name = "status")
    private boolean status;

    @Column(name = "time")
    private String time;

    @ToString.Exclude
    @ManyToOne( cascade=CascadeType.ALL,
        fetch = FetchType.LAZY)
    @JoinColumn(name = "track_habit_id")
    private TrackHabit trackHabit;

}
