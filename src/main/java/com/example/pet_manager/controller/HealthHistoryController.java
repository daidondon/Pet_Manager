package com.example.pet_manager.controller;

import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.HealthHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/healthHistory")
public class HealthHistoryController {

    @Autowired
    private HealthHistoryService healthHistoryService;

    @GetMapping("/list")
    public ResponseEntity<?> listHealthHistory(@RequestParam("pet-id") Integer petId) {
        return ResponseEntity.ok(healthHistoryService.getAll(petId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHealthHistory(@RequestBody HealthHistoryRequest healthHistoryRequest) {
        return ResponseEntity.ok(healthHistoryService.addHealthHistory(healthHistoryRequest));
    }

    @PutMapping("delete")
    public ResponseEntity<?> deleteHealthHistory(@RequestParam("healthhistory-id") Integer healthHistoryId) {
        return ResponseEntity.ok(healthHistoryService.deleteHealthHistory(healthHistoryId));
    }

}
