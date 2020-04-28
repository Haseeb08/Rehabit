package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> findAllUsers();
    UserDto findById(int id);
    void save(UserDto user);
    void deleteById(int id);
    UserDto findByEmail(String email);
    UserDto findByUserName(String userName);
}
