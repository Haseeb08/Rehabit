package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.UserRepository;
import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.User;
import com.vikingzorros.rehabit.objectmappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> findAllUsers() {

        List<User> allUsers = new ArrayList<>();
        allUsers = userRepository.findAll();
        List<UserDto> allUsersDto = new ArrayList<>();
        for(User user: allUsers)
            allUsersDto.add(userMapper.convertToDto(user));

        return allUsersDto;
    }

    @Override
    public UserDto findById(int id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            UserDto userDto = userMapper.convertToDto(user.get());
            return userDto;
        }
        else
            throw new RuntimeException("User not found :" + id);
    }

    @Override
    public void save(UserDto userDto) {
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encryptedPassword);
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        if(id>0)
            userRepository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {

        User user =  userRepository.findByEmail(email);
        UserDto userDto = null;
        if(user!=null)
            userDto = userMapper.convertToDto(user);
        return userDto;
    }

    public UserDto findByUserName(String userName) {
        // check the database if the user already exists
        User user =  userRepository.findByUserName(userName);
        UserDto userDto = null;
        if(user!=null)
            userDto = userMapper.convertToDto(user);
        return userDto;

    }

    @Override
    public UserDto findByPhoneNumber(String phoneNumber) {
        User user =  userRepository.findByPhoneNumber(phoneNumber);
        UserDto userDto = null;
        if(user!=null)
            userDto = userMapper.convertToDto(user);
        return userDto;
    }


}