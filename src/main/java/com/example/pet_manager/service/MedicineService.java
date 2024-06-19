package com.example.pet_manager.service;

import com.example.pet_manager.request.MedicineRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface MedicineService {

    EntityCustomResponse addMedicine(MedicineRequest medicineRequest);

    EntityCustomResponse getAll();

}
