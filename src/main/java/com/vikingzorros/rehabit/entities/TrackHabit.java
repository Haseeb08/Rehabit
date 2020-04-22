package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="track_habit")
public class TrackHabit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
   private int id;

    @Column(name = "notify_time")
    private String notifyTime;

    @Column(name = "response")
    private String response;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "track_habit_id")
    private Notification notification;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
