package com.example.pet_manager.service.Impl;

import com.example.pet_manager.service.UserService;
import com.example.pet_manager.entity.User;
import com.example.pet_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User loginUser(String gmail, String password) {
        Optional<User> existingUser = userRepository.findByGmail(gmail);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (!user.getPassword().equals(password)) {
               throw new BadCredentialsException("Wrong password");
            }
            return user;
            }
        else {
            throw new IllegalArgumentException("User not found");
        }

        }

    @Override
    public int addUser(User user) {
        try{
            User newUser = userRepository.save(user);
            return newUser.getId();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Boolean isExistEmail(String email) {
        return userRepository.existsByGmail(email);
    }
}

