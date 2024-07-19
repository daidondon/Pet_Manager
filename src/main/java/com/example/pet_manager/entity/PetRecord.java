package com.example.pet_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "pet_records")
public class PetRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "examination_date")
    private LocalDate examinationDate;

    @Column(name = "symptom_description")
    private String symptomDescription;

    @Column(name = "symptoms_time")
    private String symptomsTime;

    @Column(name = "body_temperature")
    private float bodyTemperature;

    @Column(name = "external_examination")
    private String externalExamination;

    @Column(name = "test_results")
    private String testResults;

    @Column(name = "preliminary_diagnosis")
    private String preliminaryDiagnosis;

    @Column(name = "medications")
    private String medications;

    @Column(name = "nutrition")
    private String nutrition;

    @Column(name = "re_examination")
    private String reExamination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "create_by")
    private Integer createBy;

    @Column(name = "create_at")
    private LocalDateTime createAt;

}
