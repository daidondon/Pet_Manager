package com.example.pet_manager.controller;

import com.example.pet_manager.request.MedicineRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/medicine")

public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/list")
    public ResponseEntity<?> listMedicine(@RequestParam Integer clinicId) {

        return ResponseEntity.ok(medicineService.getAll(clinicId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicine(@RequestBody MedicineRequest medicineRequest) {
        return ResponseEntity.ok(medicineService.addMedicine(medicineRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMedicine(@Valid @RequestBody MedicineRequest medicineRequest) {
        return ResponseEntity.ok(medicineService.updateMedicine(medicineRequest));
    }

    @PutMapping("delete")
    public ResponseEntity<?> deleteMedicine(@RequestParam Integer medicineId) {
        return ResponseEntity.ok(medicineService.deleteMedicine(medicineId));
    }
}
