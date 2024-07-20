package com.example.pet_manager.controller;

import com.example.pet_manager.request.UserRequest;
import com.example.pet_manager.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/host")
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctorUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(hostService.addDoctorUser(userRequest));
    }
}
