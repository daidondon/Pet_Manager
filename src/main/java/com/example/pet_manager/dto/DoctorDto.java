package com.example.pet_manager.dto;

import com.example.pet_manager.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DoctorDto {


    @JsonProperty("user_name")
    String userName;

    @JsonProperty("role_id")
    private int roleId;

    @JsonProperty("clinic_id")
    private int clinicId;

    @JsonProperty("link_meet")
    private String linkMeet;

    private User user;

}
