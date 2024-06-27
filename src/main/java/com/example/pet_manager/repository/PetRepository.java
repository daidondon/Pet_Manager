package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer> {

    List<Pet> findAllByOrderByCreateAtDesc();

}
