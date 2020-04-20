package com.vikingzorros.rehabit.service;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
public class AuthServiceImpl implements AuthService {

    public static final String ACCOUNT_SID = "ACeffc570395fa34c1f322f187752727d8";
    public static final String AUTH_TOKEN = "27cbf5058c5cf69e6d726ba8bae5aff5";

    @Override
    public void sendToken(String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                "VAd10bde58117cd0214c68d5860de835dd",
                phoneNumber,
                "sms")
                .create();

        //System.out.println(verification.getStatus());
    }

    @Override
    public String verifyToken(String phoneNumber,String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        VerificationCheck verificationCheck = VerificationCheck.creator(
                "VAd10bde58117cd0214c68d5860de835dd",
                otp)
                .setTo(phoneNumber).create();

        //System.out.println(verificationCheck.getStatus());
        return verificationCheck.getStatus();//approved/pending/denied
    }

}
