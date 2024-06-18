package com.example.pet_manager.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
