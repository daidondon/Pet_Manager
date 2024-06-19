package com.example.pet_manager.repository;

import com.example.pet_manager.entity.VacinationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinationHistoryRepository extends JpaRepository<VacinationHistory, Integer>{
}
