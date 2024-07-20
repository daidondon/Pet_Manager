package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty("full_name")
    private String fullName;

    private String gmail;

    private String password;

    private String address;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private int status;

    private DoctorDto doctorDto;

}
