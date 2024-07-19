package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository  extends JpaRepository<Booking, Integer> {

    List<Booking> findByDoctorIdOrderByCheckInDesc(Integer doctorId);
}
