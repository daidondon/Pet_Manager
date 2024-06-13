package com.example.pet_manager.controller;

import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/list")
    public ResponseEntity<?> listPet() {
        return ResponseEntity.ok(petService.getAll());
    }

    @PutMapping("/add")
    public ResponseEntity<?> addPet(@RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.addPet(petRequest));
    }
}
