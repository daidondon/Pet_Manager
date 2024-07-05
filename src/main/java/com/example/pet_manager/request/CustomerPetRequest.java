package com.example.pet_manager.request;

import com.example.pet_manager.entity.Pet;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CustomerPetRequest {
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "status")
    private String status;

    @Column(name = "owner_from_date")
    private LocalDateTime owner_from_date;
}
