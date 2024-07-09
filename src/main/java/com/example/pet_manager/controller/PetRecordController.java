package com.example.pet_manager.controller;

import com.example.pet_manager.request.PetRecordRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.PetRecordService;
import com.example.pet_manager.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/petRecord")
public class PetRecordController {
    @Autowired
    private PetRecordService petRecordService;

    @GetMapping("/list")
    public ResponseEntity<?> listPetRecord(@RequestParam("index-page") int indexPage, @RequestParam("size") int size,
                                     @RequestParam("pet-id") Integer petId) {
        return ResponseEntity.ok(petRecordService.getAll(indexPage, size, petId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPetRecord(@RequestBody PetRecordRequest petRecordRequest) {
        return ResponseEntity.ok(petRecordService.addPetRecord(petRecordRequest));
    }
}
