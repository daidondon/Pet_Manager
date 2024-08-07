package com.example.pet_manager.service;

import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface PetService {

    EntityCustomResponse addPet(PetRequest petRequest);

    EntityCustomResponse getAll(int indexPage, int size, Integer customerId);

    EntityCustomResponse updatePet(PetRequest petRequest);

    EntityCustomResponse deletePet(Integer petId);

}
