package com.example.pet_manager.service;

import com.example.pet_manager.request.VacinationHistoryRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface VacinationHistoryService {

    EntityCustomResponse addVacinationHistory(VacinationHistoryRequest vacinationHistoryRequest);

    EntityCustomResponse getAll(Integer petId);

}
