package com.example.pet_manager.service;


import com.example.pet_manager.entity.User;

public interface UserService {
    User loginUser(String gmail, String password);
    int addUser(User user);
    Boolean isExistEmail(String email);
}
