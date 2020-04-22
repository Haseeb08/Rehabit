package com.vikingzorros.rehabit.service;

public interface AuthService {

    String sendToken();
    String verifyToken(String otp);
}
