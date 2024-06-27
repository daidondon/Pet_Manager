package com.example.pet_manager.service;


import com.example.pet_manager.entity.User;

public interface UserService {
    User loginUser(String gmail, String password);
    void addUser(User user);
    Boolean isExistEmail(String email);
}
