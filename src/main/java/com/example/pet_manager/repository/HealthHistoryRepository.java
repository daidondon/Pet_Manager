package com.example.pet_manager.repository;

import com.example.pet_manager.entity.HealthHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HealthHistoryRepository extends JpaRepository<HealthHistory, Integer> {
    List<HealthHistory> findAllByPetId(Integer petId);

}
