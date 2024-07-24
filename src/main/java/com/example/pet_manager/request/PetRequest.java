package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetRequest {

    private Integer id; //id của pet , dùng khi update

    @NotNull(message = "id must not be null")
    @NotBlank(message = "name must not be blank")
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
