package com.example.pet_manager.repository;

import com.example.pet_manager.entity.CustomerPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerPetRepository extends JpaRepository<CustomerPet, Integer> {

}
