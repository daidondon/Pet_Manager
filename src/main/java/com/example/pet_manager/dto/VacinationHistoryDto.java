package com.example.pet_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacinationHistoryDto {

    private String description;
    private String vaccinImage;

    private PetDto pet;
}
