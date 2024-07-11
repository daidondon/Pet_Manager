package com.example.pet_manager.service;

import com.example.pet_manager.request.PetRecordRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface PetRecordService {

    EntityCustomResponse getAll(Integer petId);

}
