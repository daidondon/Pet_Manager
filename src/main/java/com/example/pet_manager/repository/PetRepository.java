package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Integer> {

    List<Pet> findAllByOrderByCreateAtDesc();

    @Query(nativeQuery = true ,value="select pet.*\n" +
            "from pet, customer_pet\n" +
            "where pet.id = owner_pet.pet_id and customer_pet.customer_id=?1 \n" +
            "order by pet.create_at")
    List<Pet> findAllByCustomerId(Integer customerId);


}
