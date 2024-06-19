package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.MedicineDto;
import com.example.pet_manager.entity.Medicine;
import com.example.pet_manager.repository.MedicineRepository;
import com.example.pet_manager.request.MedicineRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public EntityCustomResponse addMedicine(MedicineRequest medicineRequest) {
        Medicine medicine = new Medicine();

        medicine.setName(medicineRequest.getName());
        medicine.setQuantity(medicineRequest.getQuantity());
        medicine.setPrice(medicineRequest.getPrice());
        medicine.setType(medicineRequest.getType());
        medicine.setTrademark(medicineRequest.getTrademark());
        medicine.setDescrition(medicineRequest.getDescription());

        // xem cách set ngày

        Medicine medicineDb = medicineRepository.save(medicine);
        if (ObjectUtils.isEmpty(medicineDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add Medicine Success", 200, medicineDb);

    }

    @Override
    public EntityCustomResponse getAll() {
//funtion này có thực hiện được không
//        List<Medicine> listMedicine = medicineRepository.findAllByOrderByCreateAtDesc();
//        List<MedicineDto> listPetDto = listMedicine.stream().map(medicine -> modelMapper.map(medicine, MedicineDto.class))
//                .collect(Collectors.toList());

//        return new EntityCustomResponse(1, "List pet", 200, listPetDto);
        return null;
    }
}
