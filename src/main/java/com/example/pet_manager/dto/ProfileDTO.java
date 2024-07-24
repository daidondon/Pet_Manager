package com.example.pet_manager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileDTO {

    private String gmail;

    private String full_name;


    private String password;

    private String address;

    private String phone_number;
}
