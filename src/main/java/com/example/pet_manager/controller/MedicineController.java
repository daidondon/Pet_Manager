package com.example.pet_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicine")

public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/list")
    public ResponseEntity<?> listMedicine() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    @PutMapping("/add")
    public ResponseEntity<?> addMedicine(@RequestBody MedicineRequest medicineRequest) {
        return ResponseEntity.ok(medicineService.addPet(medicineRequest));
    }
}
