package com.vikingzorros.rehabit.service;

public interface AuthService {

    String sendToken(String phoneNumber);
    String verifyToken(String phoneNumber,String otp);
}
