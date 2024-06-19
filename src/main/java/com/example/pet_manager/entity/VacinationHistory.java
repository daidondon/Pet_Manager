package com.example.pet_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "vasination_history")
public class VacinationHistory extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Column(name = "vaccin_image")
    private String vaccinImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
