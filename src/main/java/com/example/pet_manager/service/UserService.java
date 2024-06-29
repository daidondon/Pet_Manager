package com.example.pet_manager.service;


import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User loginUser(String gmail, String password);
    int addUser(User user);
    Boolean isExistEmail(String email);
    List<String> findRolesByUsername(String username);
}
