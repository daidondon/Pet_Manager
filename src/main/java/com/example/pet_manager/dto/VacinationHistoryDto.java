package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacinationHistoryDto {

    private String description;

    @JsonProperty("vaccin_image")
    private String vaccinImage;

    private String name;

    @JsonProperty("injection_date")
    private Date injectionDate;

    private PetDto pet;
}
