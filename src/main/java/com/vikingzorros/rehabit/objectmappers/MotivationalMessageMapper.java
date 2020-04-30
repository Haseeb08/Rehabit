package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.MotivationalMessageDto;
import com.vikingzorros.rehabit.entities.MotivationalMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MotivationalMessageMapper {


    @Autowired
    private ModelMapper modelMapper;

    public MotivationalMessageDto convertToDto(MotivationalMessage motivationalMessage)
    {
        MotivationalMessageDto motivationalMessageDto= modelMapper.map(motivationalMessage, MotivationalMessageDto.class);

        return motivationalMessageDto;
    }

    public MotivationalMessage convertToEntity(MotivationalMessageDto theMotivationalMessageDto)
    {
        MotivationalMessage motivationalMessage = modelMapper.map(theMotivationalMessageDto, MotivationalMessage.class);
        return motivationalMessage;
    }

    public List<MotivationalMessageDto> convertToDtos(Collection<MotivationalMessage> motivationalMessages) {
        return motivationalMessages.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public final List<MotivationalMessage> convertToEntities(final Collection<MotivationalMessageDto> motivationalMessageDtos) {
        return motivationalMessageDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

}