package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacinationHistoryDto {

    private String description;

    @JsonProperty("vaccin_image")
    private String vaccinImage;

    private PetDto pet;
}
