package com.vikingzorros.rehabit.service;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.springframework.beans.factory.annotation.Value;

public class AuthServiceImpl implements AuthService {

    @Value("${twilio.accountsid}")
    private String accountSid;

    @Value("${twilio.authtoken}")
    private String authToken;

    @Value("${twilio.pathserviceid}")
    private String pathServiceId;

    @Override
    public void sendToken(String phoneNumber) {
        Twilio.init(accountSid, authToken);
        Verification verification = Verification.creator(
                pathServiceId,
                phoneNumber,
                "sms")
                .create();

        //System.out.println(verification.getStatus());
    }

    @Override
    public String verifyToken(String phoneNumber,String otp) {
        Twilio.init(accountSid, authToken);
        VerificationCheck verificationCheck = VerificationCheck.creator(
                pathServiceId,
                otp)
                .setTo(phoneNumber).create();

        //System.out.println(verificationCheck.getStatus());
        return verificationCheck.getStatus();//approved/pending/denied
    }

}
