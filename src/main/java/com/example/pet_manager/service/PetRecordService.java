package com.example.pet_manager.service;

import com.example.pet_manager.request.PetRecordRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import org.springframework.transaction.annotation.Transactional;

public interface PetRecordService {

    EntityCustomResponse getAll(Integer petId);

    EntityCustomResponse addPetRecord(PetRecordRequest petRecordRequest);

}
