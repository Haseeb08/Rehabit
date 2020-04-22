package com.vikingzorros.rehabit.service;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.vikingzorros.rehabit.config.TwilioConfigurationProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TwilioConfigurationProperties twilioConfigurationProperties;

    private String phoneNumber;

    @Override
    public String sendToken() {

        try {
            Twilio.init(twilioConfigurationProperties.getAccountSid(), twilioConfigurationProperties.getAuthToken());
            log.info("sending sms to {}", phoneNumber);
            Verification verification = Verification.creator(
                    twilioConfigurationProperties.getPathServiceId(),
                    phoneNumber,
                    "sms")
                    .create();

            log.info(verification.getStatus());
            return verification.getStatus();//status is pending for successfully sent otp/token
        }
        catch (ApiException apiException){
            log.info("====>>>{}",apiException+"");
            return "";
        }
    }

    @Override
    public String verifyToken(String otp) {

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
            log.info("====>>>{}",apiException+"");
            return "";
        }

    }

}
