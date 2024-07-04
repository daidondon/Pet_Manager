package com.example.pet_manager.service;

public interface OTPService {
    public void sendOtp(String recipientPhoneNumber, String otpCode);
}
