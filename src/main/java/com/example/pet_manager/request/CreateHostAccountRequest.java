package com.example.pet_manager.request;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
public class CreateHostAccountRequest {
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

    @NotEmpty(message = "Address clinic must be filled")
    @Size(max = 255, message = "Address clinic must have < 255 characters")
    private String address_clinic;

    @NotEmpty(message = "Name clinic must be filled")
    @Size(max = 255, message = "Name clinic must have < 255 characters")
    private String name_clinic;


}
