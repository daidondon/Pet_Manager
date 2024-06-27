package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.PetDto;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.repository.PetRepository;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;

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

        return new EntityCustomResponse(1, "Add Pet Success", 200, petDb);
    }

    @Override
    public EntityCustomResponse getAll() {

        List<Pet> listPet = petRepository.findAllByOrderByCreateAtDesc();
        List<PetDto> listPetDto = listPet.stream().map(pet -> modelMapper.map(pet, PetDto.class))
                .collect(Collectors.toList());

        return new EntityCustomResponse(1, "List pet", 200, listPetDto);
    }
}
