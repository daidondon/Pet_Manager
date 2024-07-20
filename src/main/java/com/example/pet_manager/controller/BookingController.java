package com.example.pet_manager.controller;

import com.example.pet_manager.request.BookingRequest;
import com.example.pet_manager.request.PetRequest;
import com.example.pet_manager.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    public ResponseEntity<?> listBookingByDoctorId(@RequestParam("doctor-id") Integer doctorId) {
        return ResponseEntity.ok(bookingService.getAll(doctorId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.addBooking(bookingRequest));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingRequest));
    }

}

