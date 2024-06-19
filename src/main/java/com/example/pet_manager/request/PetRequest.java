package com.example.pet_manager.request;

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

    private String originCertificate;

    private String transferContract;

    private List<HealthHistoryRequest> healthHistoryRequests;
}
