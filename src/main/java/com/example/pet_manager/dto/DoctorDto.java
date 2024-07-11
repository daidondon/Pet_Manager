package com.example.pet_manager.dto;

import com.example.pet_manager.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorDto {

    @JsonProperty("link_meet")
    private String linkMeet;

    private User user;

}
