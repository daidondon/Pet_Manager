package com.example.pet_manager.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String full_name;
}
