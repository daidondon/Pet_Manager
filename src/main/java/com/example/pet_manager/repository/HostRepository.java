package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Host;
import com.example.pet_manager.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {

}
