package com.example.pet_manager.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VacinationHistoryRequest {

    private String description;
    private String vaccinImage;
}
