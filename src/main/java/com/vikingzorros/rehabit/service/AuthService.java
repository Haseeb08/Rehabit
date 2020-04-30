package com.vikingzorros.rehabit.service;

public interface AuthService {

    boolean sendToken(String phoneNumber);
    String verifyToken(String phoneNumber,String otp);
}
