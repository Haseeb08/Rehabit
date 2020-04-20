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

//track habit id
    @OneToOne( cascade=CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "notification")
    private TrackHabit trackHabit;

}
