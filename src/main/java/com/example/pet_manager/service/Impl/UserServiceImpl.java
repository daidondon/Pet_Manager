package com.example.pet_manager.service.Impl;

import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.entity.Role;
import com.example.pet_manager.service.UserService;
import com.example.pet_manager.entity.User;
import com.example.pet_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm người dùng trong cơ sở dữ liệu bằng email (username)
        User userEntity = userRepository.findByGmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Lấy danh sách các vai trò của người dùng từ cơ sở dữ liệu
        List<String> roles = findRolesByUsername(username); // Sử dụng phương thức đã định nghĩa để lấy danh sách vai trò
        List<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                userEntity.getGmail(),
                userEntity.getPassword(),
                authorities
        );
    }

    @Override
    public List<String> findRolesByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByGmail(username);
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Sử dụng một phương thức phù hợp của userRepository để lấy danh sách các chuỗi roles
        List<String> roles = userRepository.findRolesByUsername(username);

        return roles;
    }


}


