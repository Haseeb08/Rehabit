package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.MotivationalMessage;

import java.util.List;

public interface MotivationalMessageService {

    List<MotivationalMessage> findAll();
    MotivationalMessage findById(int id);
    void save(MotivationalMessage motivationalMessage);
    void deleteById(int id);
}
