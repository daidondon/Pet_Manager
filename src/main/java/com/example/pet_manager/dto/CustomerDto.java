package com.example.pet_manager.dto;

import com.example.pet_manager.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDto {
    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_phone")
    private String customerPhone;

    @JsonProperty("customer_gmail")
    private String customerGmail;

    private User user;
}
