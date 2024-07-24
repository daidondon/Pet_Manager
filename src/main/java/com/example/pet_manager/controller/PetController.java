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
    public ResponseEntity<?> listPet(@RequestParam("index-page") int indexPage, @RequestParam("size") int size,
                                     @RequestParam("customer-id") Integer customerId) {
        return ResponseEntity.ok(petService.getAll(indexPage, size, customerId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPet(@RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.addPet(petRequest));
    }

    @PutMapping("update")
    public ResponseEntity<?> updatePet(@Valid @RequestBody PetRequest petRequest) {
        return ResponseEntity.ok(petService.updatePet(petRequest));
    }

    @PutMapping("delete")
    public ResponseEntity<?> deletePet(@RequestParam("pet-id") Integer petId) {
        return ResponseEntity.ok(petService.deletePet(petId));
    }

}
