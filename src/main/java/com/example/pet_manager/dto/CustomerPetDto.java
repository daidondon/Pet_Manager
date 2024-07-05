package com.example.pet_manager.dto;

import com.example.pet_manager.entity.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerPetDto {

    private int id;

    private Integer customer_id;

    private String status;

    private LocalDateTime owner_from_date;
}
