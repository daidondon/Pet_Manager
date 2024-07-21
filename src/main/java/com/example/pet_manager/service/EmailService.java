package com.example.pet_manager.service;

import com.example.pet_manager.request.EmailDetails;

public interface EmailService {
    boolean sendSimpleMail(EmailDetails details);

    String generateVerifyCode();
}
