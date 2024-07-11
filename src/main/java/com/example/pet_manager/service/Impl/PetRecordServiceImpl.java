package com.example.pet_manager.service.Impl;


import com.example.pet_manager.dto.DoctorDto;
import com.example.pet_manager.dto.PetRecordDto;
import com.example.pet_manager.entity.Doctor;
import com.example.pet_manager.entity.PetRecord;
import com.example.pet_manager.repository.DoctorRepository;
import com.example.pet_manager.repository.PetRecordRepository;
import com.example.pet_manager.repository.UserRepository;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.PetRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetRecordServiceImpl implements PetRecordService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PetRecordRepository petRecordRepository;

    @Override
    @Transactional
    public EntityCustomResponse getAll(Integer petId) {
        List<PetRecord> listPetRecord = petRecordRepository.findByPetId(petId);
        List<PetRecordDto> listPetRecordDto = listPetRecord.stream().map(petRecord ->{

            PetRecordDto petRecordDto = modelMapper.map(petRecord, PetRecordDto.class);
            Doctor doctor= petRecord.getDoctor();
            petRecord.getDoctor();
            DoctorDto doctorDto=modelMapper.map(doctor, DoctorDto.class);
            doctorDto.setUser(null);
            doctorDto.setUserName(petRecord.getDoctor().getUser().getFullName());
            petRecordDto.setDoctorDto(doctorDto);
            return petRecordDto;
        }).collect(Collectors.toList());

        return new EntityCustomResponse(1, "List Pet record", 200, listPetRecordDto);
    }
}
