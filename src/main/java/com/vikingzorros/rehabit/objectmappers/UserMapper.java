package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;


    public UserDto convertToDto(User user)
    {
        UserDto userDto= modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public User convertToEntity(UserDto theUserDto)
    {
        User user = modelMapper.map(theUserDto, User.class);
        return user;
    }
}