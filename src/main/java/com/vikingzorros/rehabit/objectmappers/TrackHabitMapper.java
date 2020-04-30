package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.TrackHabitDto;
import com.vikingzorros.rehabit.entities.TrackHabit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrackHabitMapper{

    @Autowired
    private ModelMapper modelMapper;

    public TrackHabitDto convertToDto(TrackHabit trackHabit)
    {
        TrackHabitDto trackHabitDto= modelMapper.map(trackHabit, TrackHabitDto.class);

        return trackHabitDto;
    }

    public TrackHabit convertToEntity(TrackHabitDto theTrackHabitDto)
    {
        TrackHabit trackHabit = modelMapper.map(theTrackHabitDto, TrackHabit.class);
        return trackHabit;
    }

    public List<TrackHabitDto> convertToDtos(Collection<TrackHabit> trackHabits) {
        return trackHabits.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public final List<TrackHabit> convertToEntities(final Collection<TrackHabitDto> trackHabitDtos) {
        return trackHabitDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}