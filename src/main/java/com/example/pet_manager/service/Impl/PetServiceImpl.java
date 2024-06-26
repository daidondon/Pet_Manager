package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.HealthHistoryDto;
import com.example.pet_manager.dto.VacinationHistoryDto;
import com.example.pet_manager.dto.PetDto;
import com.example.pet_manager.entity.HealthHistory;
import com.example.pet_manager.entity.VacinationHistory;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.repository.HealthHistoryRepository;
import com.example.pet_manager.repository.VacinationHistoryRepository;
import com.example.pet_manager.repository.PetRepository;
import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.request.VacinationHistoryRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HealthHistoryRepository healthHistoryRepository;

    @Autowired
    private VacinationHistoryRepository vacinationHistoryRepository;

    @Transactional
    @Override
    public EntityCustomResponse addPet(PetRequest petRequest) {
        Pet pet = new Pet();
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());
        pet.setGender(petRequest.isGender());
        pet.setSpecies(petRequest.getSpecies());
        pet.setIdentifying(petRequest.getIdentifying());
        pet.setOriginCertificate(petRequest.getOriginCertificate());
        pet.setTransferContract(petRequest.getTransferContract());

        pet.setCreateAt(LocalDateTime.now());
        pet.setUpdateAt(LocalDateTime.now());
        pet.setCreateBy(1);//TODO set user login
        pet.setUpdateBy(1);//TODO set user login

        Pet petDb = petRepository.save(pet);
        if (ObjectUtils.isEmpty(petDb)) {
            //TODO : exception handler
        }

        //process Health history
        List<HealthHistory> healthHistoryList = new ArrayList<>();
        for (HealthHistoryRequest data : petRequest.getHealthHistoryRequests()) {
            HealthHistory healthHistory = new HealthHistory();
            healthHistory.setDescription(data.getDescription());
            healthHistory.setPet(petDb);
            healthHistoryList.add(healthHistory);
        }
        List<HealthHistory> healthHistoryListDb = healthHistoryRepository.saveAll(healthHistoryList);
        if (ObjectUtils.isEmpty(healthHistoryListDb)) {
            //TODO : exception handler
        }

        //process Vacination history
        List<VacinationHistory> vacinationHistoryList = new ArrayList<>();
        for (VacinationHistoryRequest data : petRequest.getVacinationHistoryRequests()) {
            VacinationHistory vacinationHistory = new VacinationHistory();
            vacinationHistory.setDescription(data.getDescription());
            vacinationHistory.setVaccinImage(data.getVaccinImage());
            vacinationHistory.setName(data.getName());
            vacinationHistory.setInjectionDate(data.getInjectionDate());
            vacinationHistory.setPet(petDb);
            vacinationHistoryList.add(vacinationHistory);
        }
        List<VacinationHistory> vacinationHistoryListDb = vacinationHistoryRepository.saveAll(vacinationHistoryList);
        if (ObjectUtils.isEmpty(vacinationHistoryListDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add Pet Success", 200, petDb);
    }

    @Override
    public EntityCustomResponse getAll() {
        List<Pet> listPet = petRepository.findAllByOrderByCreateAtDesc();
        List<PetDto> listPetDto = listPet.stream().map(pet -> {
            // Ánh xạ Pet thành PetDto
            PetDto petDto = modelMapper.map(pet, PetDto.class);

            // Tạo danh sách HealthHistoryDto từ HealthHistory của Pet
            List<HealthHistoryDto> healthHistoryDtoList = pet.getHealthHistory().stream()
                    .map(healthHistory -> {
                        // Ánh xạ từng HealthHistory thành HealthHistoryDto
                        HealthHistoryDto healthHistoryDto = modelMapper.map(healthHistory, HealthHistoryDto.class);
                        // Đảm bảo trường Pet là null
                        healthHistoryDto.setPet(null);
                        return healthHistoryDto;
                    })
                    .collect(Collectors.toList());

            // Đặt danh sách HealthHistoryDto vào PetDto
            petDto.setHealthHistoryDtoList(healthHistoryDtoList);


            // Tạo danh sách VacinationHistoryDto từ VacinationHistory của Pet
            List<VacinationHistoryDto> vacinationHistoryDtoList = pet.getVacinationHistory().stream()
                    .map(vacinationHistory -> {
                        VacinationHistoryDto vacinationHistoryDto = modelMapper.map(vacinationHistory, VacinationHistoryDto.class);
                        vacinationHistoryDto.setPet(null);
                        return vacinationHistoryDto;
                    })
                    .collect(Collectors.toList());

            // Đặt danh sách VacinationHistoryDto vào PetDto
            petDto.setVacinationHistoryDtoList(vacinationHistoryDtoList);

            return petDto;
        }).collect(Collectors.toList());

        return new EntityCustomResponse(1, "List pet", 200, listPetDto);
    }
}
