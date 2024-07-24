package com.example.pet_manager.dto;


import lombok.Data;

import jakarta.validation.constraints.*;

@Data
public class RegisterDto {

    @NotEmpty(message = "Gmail must be filled")
    @Email(message = "Gmail should be valid")
    @Size(max = 50, message = "Gmail must have < 50 characters")
    private String gmail;

    @NotEmpty(message = "Full name must be filled")
    @Size(max = 50, message = "Full name must have < 50 characters")
    private String full_name;

    @NotEmpty(message = "Password must be filled")
    @Size(max = 15, message = "Password must have < 15 characters")
    private String password;

    @NotEmpty(message = "Address must be filled")
    @Size(max = 255, message = "Address must have < 255 characters")
    private String address;

    @NotEmpty(message = "Phone number must be filled")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone_number;

    //0 is verify by email
    //1 is verify by phone
    private int typeVerify;
}
