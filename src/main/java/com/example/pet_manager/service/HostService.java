package com.example.pet_manager.service;

import com.example.pet_manager.entity.Host;
import com.example.pet_manager.request.UserRequest;
import com.example.pet_manager.response.EntityCustomResponse;

public interface HostService {

    Host addHost(Host host);

    EntityCustomResponse addDoctorUser(UserRequest userRequest);
}
