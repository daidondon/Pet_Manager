package com.example.pet_manager.repository;

import com.example.pet_manager.entity.PetRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRecordRepository extends JpaRepository<PetRecord, Integer>{

    List<PetRecord> findByPetId(Integer petId);
}
