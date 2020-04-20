package com.vikingzorros.rehabit.daorepositories;

import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.TrackHabit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackHabitRepository extends JpaRepository<TrackHabit,Integer> {

    Post findByPost_id(int theId);
}
