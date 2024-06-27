package com.example.pet_manager.service;

import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface HealthHistoryService {

    EntityCustomResponse addHealthHistory(HealthHistoryRequest healthHistoryRequest);

    EntityCustomResponse getAll(Integer petId);

}
