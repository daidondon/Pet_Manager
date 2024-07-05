package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.HealthHistoryDto;
import com.example.pet_manager.dto.VacinationHistoryDto;
import com.example.pet_manager.dto.PetDto;
import com.example.pet_manager.entity.HealthHistory;
import com.example.pet_manager.entity.VacinationHistory;
import com.example.pet_manager.entity.Pet;
import com.example.pet_manager.exception.APIException;
import com.example.pet_manager.repository.HealthHistoryRepository;
import com.example.pet_manager.repository.VacinationHistoryRepository;
import com.example.pet_manager.repository.PetRepository;
import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.request.VacinationHistoryRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.response.CustomPageResponse;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
            // exception handler
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "update pet thất bại");
        }

        return new EntityCustomResponse(1, "Add Pet Success", 200, petDb);
    }

    @Override
    public EntityCustomResponse getAll(int indexPage, int size, Integer customerId) {
        //paging
        CustomPageResponse<PetDto> pageResponse = null;
        int page = indexPage - 1;
        Pageable pageable = PageRequest.of(page, size);


        Page<Pet> petPage = petRepository.findAllByCustomerId(pageable, customerId);
        List<PetDto> listPetDto = petPage.getContent().stream().map(pet -> {
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

        pageResponse = new CustomPageResponse<>(listPetDto, indexPage, size,
                petPage.getTotalElements(), petPage.getTotalPages());

        return new EntityCustomResponse(1, "List pet", 200, pageResponse);
    }

    @Override
    @Transactional //cái gì liên quan đến thao tác dữ liệu thì đều phải có transactionl
    public EntityCustomResponse updatePet(PetRequest petRequest) {
        // ở đây sẽ khác add là mình k tạo mới pet , mà sẽ tìm pet đó trong DB , rồi để update
        // nếu tìm k thấy pet để update , thì sẽ ném ra exception , và ctrl + click vào để tham khảo các mã lỗi của HttpStatus code
        // 400 sai request
        // 404 không thấy địa chỉ
        // 500 lỗi hệ thống
        // các lỗi có mã lỗi từ > 600 , thì sẽ là dev tự custom
        if (ObjectUtils.isEmpty(petRequest.getId())) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Id không được để trống");
        }

        Pet pet = petRepository.findById(petRequest.getId()).orElseThrow(() -> new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "không tìm thấy pet"));
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());
        pet.setGender(petRequest.isGender());
        pet.setSpecies(petRequest.getSpecies());
        pet.setIdentifying(petRequest.getIdentifying());
        pet.setOriginCertificate(petRequest.getOriginCertificate());
        pet.setTransferContract(petRequest.getTransferContract());

        //ở đây chỉ set mỗi trường update
        pet.setUpdateAt(LocalDateTime.now());
        pet.setUpdateBy(1);//TODO set user login

        Pet petDb = petRepository.save(pet);
        if (ObjectUtils.isEmpty(petDb)) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "update pet thất bại");
        }

        //set cái này để khi respone trả về ko có , k bị vòng lặp vô cực
        petDb.setHealthHistory(null);
        pet.setVacinationHistory(null);

        return new EntityCustomResponse(1, "Update Pet Success", 200, petDb);
    }

    @Override
    @Transactional
    public EntityCustomResponse deletePet(Integer petId) {

        if (ObjectUtils.isEmpty(petId)) {
            throw new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Id không được để trống");
        }
        // tìm rồi xóa
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "không tìm thấy pet"));
        petRepository.delete(pet);

        return new EntityCustomResponse(1, "Delete Pet Success", 200, null);
    }
}
