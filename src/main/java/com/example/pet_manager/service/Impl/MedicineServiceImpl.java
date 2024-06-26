package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.MedicineDto;
import com.example.pet_manager.dto.MedicineImageDto;
import com.example.pet_manager.entity.Medicine;
import com.example.pet_manager.entity.MedicineImage;
import com.example.pet_manager.repository.MedicineImageRepository;
import com.example.pet_manager.repository.MedicineRepository;
import com.example.pet_manager.request.MedicineImageRequest;
import com.example.pet_manager.request.MedicineRequest;
import com.example.pet_manager.response.EntityCustomResponse;
import com.example.pet_manager.service.MedicineService;
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
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicineImageRepository medicineImageRepository;


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

        // set ngày
        medicine.setCreateAt(LocalDateTime.now());
        medicine.setUpdateAt(LocalDateTime.now());
        medicine.setCreateBy(1);//TODO set user login
        medicine.setUpdateBy(1);//TODO set user login

        Medicine medicineDb = medicineRepository.save(medicine);
        if (ObjectUtils.isEmpty(medicineDb)) {
            //TODO : exception handler
        }

        List<MedicineImage> medicineImageList = new ArrayList<>();
        for (MedicineImageRequest data : medicineRequest.getMedicineImageRequests()) {
            MedicineImage medicineImage = new MedicineImage();
            medicineImage.setImage(data.getImage());
            medicineImage.setMedicine(medicineDb);
            medicineImageList.add(medicineImage);
        }
        List<MedicineImage> medicineImageListDb = medicineImageRepository.saveAll(medicineImageList);
        if (ObjectUtils.isEmpty(medicineImageListDb)) {
            //TODO : exception handler
        }

        return new EntityCustomResponse(1, "Add Medicine Success", 200, medicineDb);

    }

    @Override
    public EntityCustomResponse getAll() {

       List<Medicine> listMedicine = medicineRepository.findAllByOrderByCreateAtDesc();
        List<MedicineDto> listMedicineDto = listMedicine.stream().map(medicine ->{

            MedicineDto medicineDto = modelMapper.map(medicine, MedicineDto.class);


            List<MedicineImageDto> medicineImageDtoList = medicine.getMedicineImage().stream()
                    .map(medicineImage -> {

                        MedicineImageDto medicineImageDto = modelMapper.map(medicineImage, MedicineImageDto.class);

                        medicineImageDto.setMedicine(null);
                        return medicineImageDto;
                    })
                    .collect(Collectors.toList());


            medicineDto.setMedicineImageDtoList(medicineImageDtoList);

            return medicineDto;
    }).collect(Collectors.toList());

       return new EntityCustomResponse(1, "List medicine", 200, listMedicineDto);

    }
}
