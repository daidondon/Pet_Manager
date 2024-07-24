package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
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
