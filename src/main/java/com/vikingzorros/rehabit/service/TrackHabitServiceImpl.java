package com.vikingzorros.rehabit.service;
import com.vikingzorros.rehabit.daorepositories.PostRepository;
import com.vikingzorros.rehabit.daorepositories.TrackHabitRepository;
import com.vikingzorros.rehabit.daorepositories.UserRepository;
import com.vikingzorros.rehabit.dto.TrackHabitDto;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.TrackHabit;
import com.vikingzorros.rehabit.objectmappers.PostMapper;
import com.vikingzorros.rehabit.objectmappers.TrackHabitMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class TrackHabitServiceImpl implements TrackHabitService{

    @Autowired
    TrackHabitRepository trackHabitRepository;

    @Autowired
    PostMapper postMapper;

    @Autowired
    TrackHabitMapper trackHabitMapper;

    @Override
    @Transactional
    public List<TrackHabitDto> findAllTrackHabits() {
        return null;
    }

    @Override
    @Transactional
    public TrackHabitDto findById(int id) {
        return null;
    }

    @Override
    public void save(TrackHabitDto trackHabitDto) {
        TrackHabit trackHabit = trackHabitMapper.convertToEntity(trackHabitDto);
        trackHabitRepository.save(trackHabit);
        log.info("saved trackhabit {}",trackHabit);
    }



    @Override
    @Transactional
    public void deleteById(int id) {

    }
}