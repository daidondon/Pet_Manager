package com.example.pet_manager.controller;

import com.example.pet_manager.config.JWTConfig;
import com.example.pet_manager.dto.LoginRequestDTO;
import com.example.pet_manager.dto.LoginResponseDTO;
import com.example.pet_manager.dto.RegisterDto;
import com.example.pet_manager.entity.User;
import com.example.pet_manager.repository.UserRepository;
import com.example.pet_manager.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RequestMapping("api/auth")
@RestController
public class AuthController {
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    public AuthController( UserService userService) {
//
        this.userService = userService;
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userService.isExistEmail(registerDto.getGmail())) {
            return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setGmail(registerDto.getGmail());
        user.setPassword(registerDto.getPassword());
        user.setPhone_number(registerDto.getPhone_number());
        user.setFull_name(registerDto.getFull_name());
        user.setAddress(registerDto.getAddress());

        userService.addUser(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User userEntity, HttpSession session, HttpServletResponse response) {
        try {

            LoginRequestDTO loginRequestDTO = modelMapper.map(userEntity, LoginRequestDTO.class);

            User user = userService.loginUser(loginRequestDTO.getGmail(), loginRequestDTO.getPassword());

            String token = JWTConfig.generateToken(response,user.getFull_name());
            LoginResponseDTO responseDTO = new LoginResponseDTO(token,user.getFull_name());
            session.setAttribute("name", user.getFull_name());
            session.setAttribute("token", token);
            return ResponseEntity.ok(responseDTO);
        } catch (IllegalArgumentException e) {
            // Nếu có lỗi xảy ra trong quá trình đăng nhập, trả về lỗi UNAUTHORIZED
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}