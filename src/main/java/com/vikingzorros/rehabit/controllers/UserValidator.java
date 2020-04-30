package com.vikingzorros.rehabit.controllers;

import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.service.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Getter
public class UserValidator {

    @Autowired
    private UserService userService;

    private String errorInfo;

    public boolean isValid(UserDto userDto){

        errorInfo = "";
        if(userNameExists(userDto.getUserName()))
            errorInfo += "User name";
        if(emailExists(userDto.getEmail()))
            errorInfo += " Email";
        if(phoneNumberExists(userDto.getPhoneNumber()))
            errorInfo += " Phone number";

        if(errorInfo.isEmpty())
            return true;
        else{
            errorInfo += " already exists";
            return false;
        }

    }
    private boolean userNameExists(String userName) {
        // check the database if user name already exists
        UserDto existing = userService.findByUserName(userName);
        if (existing != null){
            log.error("User name already exists.");
            return true;
        }
        return false;
    }
    private boolean emailExists(String email) {
        // check the database if user email already exists
        UserDto existing = userService.findByEmail(email);
        if (existing != null){
            log.error("Eamil already exists.");
            return true;
        }
        return false;
    }
    private boolean phoneNumberExists(String phoneNumber) {
        // check the database if user phone number already exists
        UserDto existing = userService.findByPhoneNumber(phoneNumber);
        if (existing != null){
            log.error("Phone Number already exists.");
            return true;
        }
        return false;
    }

}
