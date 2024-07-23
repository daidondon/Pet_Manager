package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetRecordRequest {

    private Integer id;

    @NotNull(message = "id must not be null")
    @NotBlank(message = "name must not be blank")
    @JsonProperty("pet_id")
    private Integer petId;

    @JsonProperty("doctor_id")
    private Integer doctorId;

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