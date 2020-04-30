package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.TrackHabitDto;
import com.vikingzorros.rehabit.entities.TrackHabit;

import java.util.List;

public interface TrackHabitService {

    List<TrackHabitDto> findAllTrackHabits();
    TrackHabitDto findById(int id);
    void save(TrackHabitDto trackHabit);
    void deleteById(int id);
}
