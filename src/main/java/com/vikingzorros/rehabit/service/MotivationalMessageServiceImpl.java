package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.MotivationalMessagesRepository;
import com.vikingzorros.rehabit.dto.MotivationalMessageDto;
import com.vikingzorros.rehabit.entities.MotivationalMessage;
import com.vikingzorros.rehabit.objectmappers.MotivationalMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MotivationalMessageServiceImpl implements MotivationalMessageService{

    @Autowired
    public MotivationalMessagesRepository motivationalMessagesRepository;

    @Autowired
    public MotivationalMessageMapper motivationalMessageMapper;

    @Override
    public List<MotivationalMessageDto> findAll() {
        return null;
    }

    @Override
    public MotivationalMessageDto findById(int id) {
        Optional<MotivationalMessage> motivationalMessage = motivationalMessagesRepository.findById(id);
        MotivationalMessageDto motivationalMessageDto = null;
        if(motivationalMessage.isPresent()){
            motivationalMessageDto = motivationalMessageMapper.convertToDto(motivationalMessage.get());
        }

        return motivationalMessageDto;
    }

    @Override
    public void save(MotivationalMessageDto motivationalMessage) {
    }

    @Override
    public void deleteById(int id) {

    }
}
