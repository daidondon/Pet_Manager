package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorRequest {

    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("role_id")
    private int roleId;

    @JsonProperty("clinic_id")
    private int clinicId;

    @JsonProperty("link_meet")
    private String linkMeet;

}
