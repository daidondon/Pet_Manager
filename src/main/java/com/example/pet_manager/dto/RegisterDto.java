package com.example.pet_manager.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterDto {

    @NotNull(message = "Gmail must not be null")
    @Email(message = "Gmail should be valid")
    @Size(max = 50, message = "Gmail must have < 50 characters")
    private String gmail;

    @NotNull(message = "Full name must not be null")
    @Size(max = 50, message = "Full name must have < 50 characters")
    private String full_name;

    @NotNull(message = "Password must not be null")
    @Size(max = 15, message = "Password must have < 15 characters")
    private String password;

    @NotNull(message = "Address must not be null")
    @Size(max = 255, message = "Address must have < 255 characters")
    private String address;

    @NotNull(message = "Phone number must not be null")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone_number;
}
