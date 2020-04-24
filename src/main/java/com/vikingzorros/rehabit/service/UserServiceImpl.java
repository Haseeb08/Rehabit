package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.UserRepository;
import com.vikingzorros.rehabit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {

        List<User> allUsers = new ArrayList<>();
        allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User findById(int id) {

        Optional<User> theUser = userRepository.findById(id);

        if(theUser.isPresent())
            return theUser.get();
        else
            throw new RuntimeException("User not found :" + id);
    }

    @Override
    public void save(User theUser) {

        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int id) {

        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userRepository.findByUserName(userName);
    }
}
