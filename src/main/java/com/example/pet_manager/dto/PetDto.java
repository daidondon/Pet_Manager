package com.example.pet_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetDto  {

    private Long id;

    private String name;

    private int age;

    private boolean gender;

    private String species;

    private String identifying;

    private String originCertificate;

    private String transferContract;
}
