package com.example.pet_manager.request;

import com.example.pet_manager.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private int id;

    @NotNull(message = "id must not be null")
    @NotBlank(message = "name must not be blank")
    @JsonProperty("full_name")
    private String fullName;

    private String gmail;

    private String password;

    private String address;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private int status;

    @JsonProperty("doctor_request")
    private DoctorRequest doctorRequest;

}
