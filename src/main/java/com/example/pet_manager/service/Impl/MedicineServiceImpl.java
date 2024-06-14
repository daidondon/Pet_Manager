package com.example.pet_manager.service.Impl;

import com.example.pet_manager.repository.PetRepository;
import com.example.pet_manager.request.MedicineRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.MedicineService;
import com.example.pet_manager.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EntityCustomResponse addMedicine(MedicineRequest medicineRequest) {
        return null;
    }

    @Override
    public EntityCustomResponse getAll() {
        return null;
    }
}
