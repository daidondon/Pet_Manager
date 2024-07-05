package com.example.pet_manager.controller;

import com.example.pet_manager.config.JWTConfig;
import com.example.pet_manager.dto.LoginRequestDTO;
import com.example.pet_manager.dto.LoginResponseDTO;
import com.example.pet_manager.dto.ProfileDTO;
import com.example.pet_manager.dto.RegisterDto;
import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;

import com.example.pet_manager.request.EmailDetails;
import com.example.pet_manager.request.ProfileRequest;
import com.example.pet_manager.service.CustomerService;
import com.example.pet_manager.service.EmailService;
import com.example.pet_manager.service.OTPService;
import com.example.pet_manager.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private OTPService otpService;

    public AuthController(UserService userService) {
//
        this.userService = userService;
    }
    @Autowired
    private JWTConfig jwtConfig;

    private HttpServletRequest getCurrentHttpRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }
    @GetMapping("/profile")
    public ResponseEntity<ProfileDTO> getProfile() {
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        String jwt = authorizationHeader.substring(7);
        String email = jwtConfig.extractEmail(jwt);

        ProfileDTO user = userService.getUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {
        try {
            if (userService.isExistEmail(registerDto.getGmail())) {
                return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
            }


            String code = emailService.generateVerifyCode();
            if(registerDto.getTypeVerify() == 0) {
                EmailDetails emailDetails = new EmailDetails();
                emailDetails.setSubject("Verify Code");
                emailDetails.setMsgBody(code);
                emailDetails.setRecipient(registerDto.getGmail());
                boolean check = emailService.sendSimpleMail(emailDetails);
                if (!check) {

                    return new ResponseEntity<>("Sending code for verify to email fail!!", HttpStatus.BAD_REQUEST);
                }
            }else{
                boolean check = otpService.sendOtp(registerDto.getPhone_number(),code);
                if (!check) {

                    return new ResponseEntity<>("Sending code for verify to phone fail!!", HttpStatus.BAD_REQUEST);
                }
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
    @PostMapping("update-profile")
    public ResponseEntity<String> updateProfile(@RequestBody @Valid ProfileRequest profileRequest) {
        try {




            User user = new User();
            user.setPassword(profileRequest.getPassword());
            user.setPhone_number(profileRequest.getPhone_number());
            user.setFull_name(profileRequest.getFull_name());
            user.setAddress(profileRequest.getAddress());



            return new ResponseEntity<>("Update successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {

        User user = userService.loginUser(loginRequestDTO.getGmail(), loginRequestDTO.getPassword());
        String token = JWTConfig.generateToken(response, user.getGmail());
        Set<String> role = userService.findRolesByUsername(user.getGmail());
        return ResponseEntity.ok(new LoginResponseDTO(token, user.getFull_name(), role));
    }

    @GetMapping("show")
    public String hello() {
        return "Hello World";
    }


}