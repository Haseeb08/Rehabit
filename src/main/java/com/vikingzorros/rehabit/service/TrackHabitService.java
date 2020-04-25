package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.TrackHabit;

import java.util.List;

public interface TrackHabitService {

    List<TrackHabit> findAllTrackHabits();
    TrackHabit findById(int id);
    void save(TrackHabit trackHabit);
    void deleteById(int id);
}
