package com.example.pet_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {

    private Integer id;

    @JsonProperty("check_in")
    private LocalDateTime checkIn;

    @JsonProperty("check_out")
    private LocalDateTime checkOut;

    private String content;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_phone")
    private String customerPhone;

    @JsonProperty("customer_gmail")
    private String customerGmail;

}
