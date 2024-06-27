package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthHistoryRequest {

    private String description;

    @JsonProperty("pet_id")
    private Integer petId;

}
