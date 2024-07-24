package com.example.pet_manager.dto;

import com.example.pet_manager.entity.Role;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String full_name;
    private Set<String> roles;
}