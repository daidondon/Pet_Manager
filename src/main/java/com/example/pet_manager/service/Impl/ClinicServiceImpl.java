package com.example.pet_manager.service.Impl;

import com.example.pet_manager.entity.Clinic;
import com.example.pet_manager.entity.Host;
import com.example.pet_manager.repository.ClinicRepository;
import com.example.pet_manager.repository.HostRepository;
import com.example.pet_manager.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    ClinicRepository clinicRepository;
    @Override
    public void addClinic(Clinic clinic) {
        try{
            clinicRepository.save(clinic);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
