package com.vikingzorros.rehabit.service;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.vikingzorros.rehabit.config.TwilioConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    TwilioConfigurationProperties twilioConfigurationProperties;

    @Override
    public String sendToken(String phoneNumber) {

        Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
        log.info("sending sms to {}",phoneNumber);
        Verification verification = Verification.creator(
                twilioConfigurationProperties.getPathServiceId(),
                phoneNumber,
                "sms")
                .create();

        //log.info(verification.getStatus());
        return verification.getStatus();//status is pending for successfully sent otp/token
    }

    @Override
    public String verifyToken(String phoneNumber,String otp) {

        Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
        VerificationCheck verificationCheck = VerificationCheck.creator(
                twilioConfigurationProperties.getPathServiceId(),
                otp)
                .setTo(phoneNumber).create();

        //log.info(verificationCheck.getStatus());
        return verificationCheck.getStatus();//status - approved(otp matched)
                                             // /pending(not matched)/denied(otp timed out)
    }

}
