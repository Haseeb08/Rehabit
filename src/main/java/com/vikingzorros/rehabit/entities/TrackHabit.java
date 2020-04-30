package com.vikingzorros.rehabit.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
    mappedBy = "trackHabit")
    private List<Notification> notificationList ;

    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Post post;

}
