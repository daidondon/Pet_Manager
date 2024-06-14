package com.example.pet_manager.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineRequest {

    private String name;

    private int quantity;

    private int price;

    private String type;

    private String trademark;

    private String description;
}
