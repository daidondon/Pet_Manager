package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            "SELECT u FROM User u WHERE u.gmail = :gmail"
    )
    Optional<User> findByGmail(@Param("gmail") String gmail);

    Boolean existsByGmail(String gmail);
    @Query("SELECT r.name FROM User u JOIN u.customers c JOIN c.role r WHERE u.gmail = :gmail")
    List<String> findRolesByUsername(@Param("gmail") String username);

}
