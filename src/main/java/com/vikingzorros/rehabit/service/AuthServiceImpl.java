package com.vikingzorros.rehabit.service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.vikingzorros.rehabit.configs.TwilioConfigurationProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
@Setter
@Getter
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TwilioConfigurationProperties twilioConfigurationProperties;

    @Override
    public boolean sendToken(String phoneNumber) {

        try {
            Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
            log.info("sending sms to {}", phoneNumber);
            Verification verification = Verification.creator(
                    twilioConfigurationProperties.getPathServiceId(),
                    phoneNumber,
                    "sms")
                    .create();

            log.info(verification.getStatus());
            return true;
        }
        catch (ApiException apiException){
            log.error("====>>>{}",apiException+"");
            return false;
        }
    }

    @Override
    public String verifyToken(String phoneNumber,String otp) {

        try {
            Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
            VerificationCheck verificationCheck = VerificationCheck.creator(
                    twilioConfigurationProperties.getPathServiceId(),
                    otp)
                    .setTo(phoneNumber).create();

            log.info(verificationCheck.getStatus());
            return verificationCheck.getStatus();//status - approved(otp matched)
            // /pending(not matched)/denied(otp timed out)
        }
        catch (ApiException apiException){
            log.error("====>>>{}",apiException+"");
            return "";
        }

    }

}
