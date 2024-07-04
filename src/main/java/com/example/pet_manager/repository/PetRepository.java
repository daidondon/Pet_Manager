package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findAllByOrderByCreateAtDesc();

    @Query(value = "select p from Pet p join CustomerPet cp on p.id = cp.pet.id where cp.customer_id = :customerId ")//hsql
    Page<Pet> findAllByCustomerId(Pageable pageable,@Param("customerId") Integer customerId);


}
