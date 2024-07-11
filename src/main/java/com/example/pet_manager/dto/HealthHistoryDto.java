package com.example.pet_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthHistoryDto  {
    private Integer id;

    private String description;

    private PetDto pet;

}
