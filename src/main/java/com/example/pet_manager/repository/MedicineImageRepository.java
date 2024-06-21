package com.example.pet_manager.repository;

import com.example.pet_manager.entity.MedicineImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface MedicineImageRepository extends JpaRepository<MedicineImageRepository, Integer> {
}
