package com.example.pet_manager.service.Impl;

import com.example.pet_manager.service.EmailService;
import com.example.pet_manager.service.OTPService;
import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class OTPServiceImpl implements OTPService {
    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;



    private final TwilioRestClient twilioRestClient;

    public OTPServiceImpl(@Value("${twilio.accountSid}") String accountSid,
                      @Value("${twilio.authToken}") String authToken) {
        twilioRestClient = new TwilioRestClient.Builder(accountSid, authToken).build();
    }


    public boolean sendOtp(String recipientPhoneNumber, String otpCode) {
        try{
            Message.creator(new PhoneNumber("+84"+recipientPhoneNumber.substring(1)), new PhoneNumber(twilioPhoneNumber),
                            "Your OTP code is: " + otpCode)
                    .create(twilioRestClient);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
