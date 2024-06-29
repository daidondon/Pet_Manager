package com.example.pet_manager.controller;

import com.example.pet_manager.config.JWTConfig;
import com.example.pet_manager.dto.LoginRequestDTO;
import com.example.pet_manager.dto.LoginResponseDTO;
import com.example.pet_manager.dto.RegisterDto;
import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;

import com.example.pet_manager.request.EmailDetails;
import com.example.pet_manager.service.CustomerService;
import com.example.pet_manager.service.EmailService;
import com.example.pet_manager.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;

    public AuthController(UserService userService) {
//
        this.userService = userService;
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {
        try {
            if (userService.isExistEmail(registerDto.getGmail())) {
                return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
            }


            String code = emailService.generateVerifyCode();
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setSubject("Verify Code");
            emailDetails.setMsgBody(code);
            emailDetails.setRecipient(registerDto.getGmail());
            boolean check = emailService.sendSimpleMail(emailDetails);
            if (!check) {

                return new ResponseEntity<>("Sending code for verify to email fail!!", HttpStatus.OK);
            }
            User user = new User();
            user.setGmail(registerDto.getGmail());
            user.setPassword(registerDto.getPassword());
            user.setPhone_number(registerDto.getPhone_number());
            user.setFull_name(registerDto.getFull_name());
            user.setAddress(registerDto.getAddress());
            user.setVerify(code);
            user.setStatus(0);
            int idUser = userService.addUser(user);
            customerService.addCustomer(idUser);


            return new ResponseEntity<>("Please check your phone or mail to verify", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {

            User user = userService.loginUser(loginRequestDTO.getGmail(), loginRequestDTO.getPassword());

            String token = JWTConfig.generateToken(response, user.getGmail());
            List<String> role = userService.findRolesByUsername(user.getGmail());
            return ResponseEntity.ok(new LoginResponseDTO(token, user.getFull_name(), role));
        }

    @GetMapping("show")
    public String hello() {
        return "Hello World";
    }


}