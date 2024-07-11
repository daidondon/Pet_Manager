package com.example.pet_manager.dto;

import com.example.pet_manager.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorDto {

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("link_meet")
    private String linkMeet;

    private User user;

}
