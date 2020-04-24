package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAllUsers();
    User findById(int id);
    void save(User user);
    void deleteById(int id);
    User findByEmail(String email);
    User findByUserName(String userName);

}
