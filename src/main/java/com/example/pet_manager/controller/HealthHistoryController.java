package com.example.pet_manager.controller;

import com.example.pet_manager.request.HealthHistoryRequest;
import com.example.pet_manager.service.HealthHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/healthHistory")
public class HealthHistoryController {

    @Autowired
    private HealthHistoryService healthHistoryService;

    @GetMapping("/list")
    public ResponseEntity<?> listHealthHistory(@RequestParam Integer petId) {
        return ResponseEntity.ok(healthHistoryService.getAll(petId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHealthHistory(@RequestBody HealthHistoryRequest healthHistoryRequest) {
        return ResponseEntity.ok(healthHistoryService.addHealthHistory(healthHistoryRequest));
    }

}
