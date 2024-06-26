package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.VacinationHistoryDto;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.entity.VacinationHistory;
import com.example.pet_manager.repository.VacinationHistoryRepository;
import com.example.pet_manager.request.VacinationHistoryRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.VacinationHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VacinationHistoryServiceImpl implements VacinationHistoryService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VacinationHistoryRepository vacinationHistoryRepository;

    @Transactional
    @Override
    public EntityCustomResponse addVacinationHistory(VacinationHistoryRequest vacinationHistoryRequest) {

        VacinationHistory vacinationHistory = new VacinationHistory();
        vacinationHistory.setName(vacinationHistoryRequest.getName());
        vacinationHistory.setDescription(vacinationHistoryRequest.getDescription());
        vacinationHistory.setVaccinImage(vacinationHistoryRequest.getVaccinImage());
        vacinationHistory.setInjectionDate(vacinationHistoryRequest.getInjectionDate());

        Pet pet = new Pet();
        pet.setId(vacinationHistoryRequest.getPetId());
        vacinationHistory.setPet(pet);

        vacinationHistory.setCreateBy(1);//TODO set user login

        VacinationHistory vacinationHistoryDb = vacinationHistoryRepository.save(vacinationHistory);
        if (ObjectUtils.isEmpty(vacinationHistoryDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add Pet Success", 200, vacinationHistoryDb);
    }

    @Override
    public EntityCustomResponse getAll(Integer petId) {
        List<VacinationHistory> listVacinationHistory = vacinationHistoryRepository.findAllByPetId(petId);
        List<VacinationHistoryDto> listVacinationHistoryDto = listVacinationHistory.stream().map(vacinationHistory -> {
            // Ánh xạ Pet thành PetDto
            VacinationHistoryDto vacinationHistoryDto = modelMapper.map(vacinationHistory, VacinationHistoryDto.class);
            return vacinationHistoryDto;
        }).collect(Collectors.toList());

        return new EntityCustomResponse(1, "List vacination history", 200, listVacinationHistoryDto);
    }


}
