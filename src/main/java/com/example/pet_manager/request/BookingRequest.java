package com.example.pet_manager.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingRequest {

    @NotNull(message = "id must not be null")
    @NotBlank(message = "name must not be blank")
    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("check_in")
    private LocalDateTime checkIn;

    @JsonProperty("check_out")
    private LocalDateTime checkOut;

    private String content;
}
