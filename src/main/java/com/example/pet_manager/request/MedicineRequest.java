package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineRequest {

    private Integer id;

    @NotNull(message = "id must not be null")
    @NotBlank(message = "name must not be blank")
    private String name;

    private int quantity;

    private int price;

    private String type;

    private String trademark;

    private String description;

    @JsonProperty("medicine_image_requests")
    private List<MedicineImageRequest> medicineImageRequests;

    @JsonProperty("clinic_id")
    private Integer clinicId;
}
