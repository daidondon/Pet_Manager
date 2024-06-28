package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetRequest {

    private Integer id; //id của pet , dùng khi update

    @NotNull(message = "id must not be null") // thêm cái này để nó tự bắn lỗi , vì đã config exception handle
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
