package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetRequest {

    private String name;

    private int age;

    private boolean gender;

    private String species;

    private String identifying;

    @JsonProperty("origin_certificate")
    private String originCertificate;

    @JsonProperty("transfer_contract")
    private String transferContract;

    @JsonProperty("health_history_requests")
    private List<HealthHistoryRequest> healthHistoryRequests;

    @JsonProperty("vacination_history_requests")
    private List<VacinationHistoryRequest> vacinationHistoryRequests;
}
