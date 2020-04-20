package com.vikingzorros.rehabit.service;

public interface AuthService {

    void sendToken(String phoneNumber);
    String verifyToken(String phoneNumber,String otp);
}
