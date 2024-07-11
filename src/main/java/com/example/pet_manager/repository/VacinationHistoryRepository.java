package com.example.pet_manager.repository;

import com.example.pet_manager.entity.VacinationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacinationHistoryRepository extends JpaRepository<VacinationHistory, Integer>{


    List<VacinationHistory> findAllByPetId(Integer petId);

    @Query(value = "select vh from VacinationHistory vh where vh.name LIKE CONCAT('%',:vacciname,'%')  and  vh.pet.id =:petId")
    List<VacinationHistory> findByName(@Param("petId")Integer petId, @Param("vacciname") String vacciname);
}

