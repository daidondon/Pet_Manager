package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.HealthHistoryDto;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.entity.HealthHistory;
import com.example.pet_manager.exception.APIException;
import com.example.pet_manager.repository.HealthHistoryRepository;
import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.HealthHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class HealthHistoryServiceImpl implements HealthHistoryService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HealthHistoryRepository healthHistoryRepository;

    @Transactional
    @Override
    public EntityCustomResponse addHealthHistory(HealthHistoryRequest healthHistoryRequest) {

        HealthHistory healthHistory = new HealthHistory();
        healthHistory.setDescription(healthHistoryRequest.getDescription());

        Pet pet = new Pet();
        pet.setId(healthHistoryRequest.getPetId());
        healthHistory.setPet(pet);

        healthHistory.setCreateBy(1);//TODO set user login
        healthHistory.setCreateAt(LocalDateTime.now());

        HealthHistory healthHistoryDb = healthHistoryRepository.save(healthHistory);
        if (ObjectUtils.isEmpty(healthHistoryDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add health history Success", 200, healthHistoryDb);
    }

    @Override
    public EntityCustomResponse getAll(Integer petId) {
        List<HealthHistory> listHealthHistory = healthHistoryRepository.findAllByPetId(petId);
        List<HealthHistoryDto> listHealthHistoryDto = listHealthHistory.stream().map(healthHistory -> {
            // Ánh xạ Pet thành PetDto
            HealthHistoryDto healthHistoryDto = modelMapper.map(healthHistory, HealthHistoryDto.class);
            return healthHistoryDto;
        }).collect(Collectors.toList());

        return new EntityCustomResponse(1, "List health history", 200, listHealthHistoryDto);
    }

    @Override
    @Transactional
    public EntityCustomResponse deleteHealthHistory(Integer healthHistoryId) {

        if (ObjectUtils.isEmpty(healthHistoryId)) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Id không được để trống");
        }
        // tìm rồi xóa
        HealthHistory healthHistory = healthHistoryRepository.findById(healthHistoryId).orElseThrow(() -> new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "không tìm thấy Health History"));
        healthHistoryRepository.delete(healthHistory);

        return new EntityCustomResponse(1, "Delete Health History Success", 200, null);
    }

}
