package com.example.pet_manager.service;

public interface OTPService {
    public boolean sendOtp(String recipientPhoneNumber, String otpCode);
}
