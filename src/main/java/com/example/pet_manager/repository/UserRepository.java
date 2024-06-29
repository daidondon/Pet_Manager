package com.example.pet_manager.repository;

import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            "SELECT u FROM User u WHERE u.gmail = :gmail"
    )
    Optional<User> findByGmail(@Param("gmail") String gmail);

    Boolean existsByGmail(String gmail);

    @Query("SELECT DISTINCT r.name " +
            "FROM User u " +
            "LEFT JOIN Admin a ON u.id = a.user.id " +
            "LEFT JOIN Doctor d ON u.id = d.user.id " +
            "LEFT JOIN Host h ON u.id = h.user.id " +
            "LEFT JOIN Customer c ON u.id = c.user.id " +
            "LEFT JOIN Role r ON a.role.id = r.id OR d.role.id = r.id OR h.role.id = r.id OR c.role.id = r.id " +
            "WHERE u.gmail = :gmail")
    Set<String> findRolesByUsername(@Param("gmail") String username);
}
