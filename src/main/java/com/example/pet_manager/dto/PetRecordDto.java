package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PetRecordDto {

    private Integer id;

    @JsonProperty("examination_date")
    private LocalDate examinationDate;

    @JsonProperty("symptom_description")
    private String symptomDescription;

    @JsonProperty("symptoms_time")
    private String symptomsTime;

    @JsonProperty("body_temperature")
    private float bodyTemperature;

    @JsonProperty("external_examination")
    private String externalExamination;

    @JsonProperty("test_results")
    private String testResults;

    @JsonProperty("preliminary_diagnosis")
    private String preliminaryDiagnosis;

    private String medications;

    private String nutrition;

    @JsonProperty("re_examination")
    private String reExamination;


}
