package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    List<Medicine> findAllByOrderByCreateAtDesc();

    Medicine findByNameAndAgeAndSpeciesRegexOrderByCreateAtDesc(String name, int age, String species);
    Medicine findById(int id);
}
