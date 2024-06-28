package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer (user_id, role_id) VALUES (:userId, 1)", nativeQuery = true)
    void addCustomer(@Param("userId") int userId);


}
