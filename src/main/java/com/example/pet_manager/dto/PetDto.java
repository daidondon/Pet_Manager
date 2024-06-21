package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetDto {

    private Long id;

    private String name;

    private int age;

    private boolean gender;

    private String species;

    private String identifying;

    @JsonProperty("origin_certificate")
    private String originCertificate;

    @JsonProperty("transfer_contract")
    private String transferContract;

    @JsonProperty("health_history_dto_list")
    private List<HealthHistoryDto> healthHistoryDtoList;

    @JsonProperty("vacination_history_dto_list")
    private List<VacinationHistoryDto> vacinationHistoryDtoList;

}
