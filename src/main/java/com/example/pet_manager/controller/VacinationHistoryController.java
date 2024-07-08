package com.example.pet_manager.controller;

import com.example.pet_manager.request.VacinationHistoryRequest;
import com.example.pet_manager.service.VacinationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacinationHistory")
public class VacinationHistoryController {

    @Autowired
    private VacinationHistoryService vacinationHistoryService;

    @GetMapping("/list")
    public ResponseEntity<?> listVacinationHistory(@RequestParam("pet-id") Integer petId) {
        return ResponseEntity.ok(vacinationHistoryService.getAll(petId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVacinationHistory(@RequestBody VacinationHistoryRequest vacinationHistoryRequest) {
        return ResponseEntity.ok(vacinationHistoryService.addVacinationHistory(vacinationHistoryRequest));
    }

    @PutMapping("delete")
    public ResponseEntity<?> deleteVacinationHistory(@RequestParam("vacinationhistory-id") Integer vacinationHistoryId) {
        return ResponseEntity.ok(vacinationHistoryService.deleteVacinationHistory(vacinationHistoryId));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByNameVacinationHistory(@RequestParam("pet-id") Integer petId, @RequestParam String vacciname) {
        return ResponseEntity.ok(vacinationHistoryService.findByName(petId, vacciname));
    }

}
