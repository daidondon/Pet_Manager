package com.example.pet_manager.dto;

import com.example.pet_manager.entity.Role;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String full_name;
    private List<String> roles;
}