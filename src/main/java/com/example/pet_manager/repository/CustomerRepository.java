package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer (user_id, role_id) VALUES (:userId, 3)", nativeQuery = true)
    void addCustomer(@Param("userId") int userId);


}
