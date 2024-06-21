package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacinationHistoryRequest {

    private String description;

    @JsonProperty("vaccin_image")
    private String vaccinImage;
}
