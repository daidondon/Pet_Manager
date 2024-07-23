package com.example.pet_manager.service;

import com.example.pet_manager.request.UserRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface HostService {

    EntityCustomResponse addDoctorUser(UserRequest userRequest);
}
