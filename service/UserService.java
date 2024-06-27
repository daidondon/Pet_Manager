package com.example.petbe.services;


import com.example.petbe.entity.User;

public interface UserService {
    User loginUser(String gmail, String password);
    void addUser(User user);
    Boolean isExistEmail(String email);
}
