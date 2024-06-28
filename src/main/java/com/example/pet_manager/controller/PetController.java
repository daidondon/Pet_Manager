package com.example.pet_manager.controller;

import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.PetService;
import jakarta.validation.Valid;
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

    @PostMapping("/add")
    public ResponseEntity<?> addPet(@RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.addPet(petRequest));
    }

    @PostMapping("update")
    public ResponseEntity<?> updatePet(@Valid @RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.updatePet(petRequest));
    }

    @PostMapping("delete")
    public ResponseEntity<?> deletePet(@RequestParam Integer petId) {
        return ResponseEntity.ok(petService.deletePet(petId));
    }

}
