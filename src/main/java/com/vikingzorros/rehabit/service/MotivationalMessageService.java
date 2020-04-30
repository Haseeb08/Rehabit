package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.MotivationalMessageDto;
import com.vikingzorros.rehabit.entities.MotivationalMessage;

import java.util.List;

public interface MotivationalMessageService {

    List<MotivationalMessageDto> findAll();
    MotivationalMessageDto findById(int id);
    void save(MotivationalMessageDto motivationalMessage);
    void deleteById(int id);
}
