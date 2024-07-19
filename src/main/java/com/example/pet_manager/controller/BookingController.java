package com.example.pet_manager.controller;

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
    public ResponseEntity<?> addHealthHistory(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.addBooking(bookingRequest));
    }

}

