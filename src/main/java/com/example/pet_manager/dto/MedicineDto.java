package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
<<<<<<< HEAD
import javax.persistence.Column;
=======
import jakarta.persistence.Column;
>>>>>>> 1c621972ee8e90c9d1c3740406349501a87ce571
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDto {

    private Long id;

    private String name;

    private int quantity;

    private int price;

    private String type;

    private String trademark;

    private String descrition;

    private Integer clinicId;

    @JsonProperty("medicine_image")
    private List<MedicineImageDto> medicineImageDtoList;

}
