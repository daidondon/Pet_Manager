package com.example.pet_manager.controller;

import com.example.pet_manager.config.JWTConfig;
import com.example.pet_manager.dto.LoginRequestDTO;
import com.example.pet_manager.dto.LoginResponseDTO;
import com.example.pet_manager.dto.RegisterDto;
import com.example.pet_manager.entity.Customer;
import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;
import com.example.pet_manager.repository.UserRepository;
import com.example.pet_manager.request.EmailDetails;
import com.example.pet_manager.service.CustomerService;
import com.example.pet_manager.service.EmailService;
import com.example.pet_manager.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;

    public AuthController( UserService userService) {
//
        this.userService = userService;
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {
        try{
            if (userService.isExistEmail(registerDto.getGmail())) {
                return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
            }

            User user = new User();
            user.setGmail(registerDto.getGmail());
            user.setPassword(registerDto.getPassword());
            user.setPhone_number(registerDto.getPhone_number());
            user.setFull_name(registerDto.getFull_name());
            user.setAddress(registerDto.getAddress());

            int idUser = userService.addUser(user);
            customerService.addCustomer(idUser);

            String code = emailService.generateVerifyCode();
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setSubject("Verify Code");
            emailDetails.setMsgBody(code);
            emailDetails.setRecipient(registerDto.getGmail());
            boolean check = emailService.sendSimpleMail(emailDetails);


            return new ResponseEntity<>("Please check your phone or mail to verify", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User userEntity, HttpSession session, HttpServletResponse response) {
        try {

            LoginRequestDTO loginRequestDTO = modelMapper.map(userEntity, LoginRequestDTO.class);

            User user = userService.loginUser(loginRequestDTO.getGmail(), loginRequestDTO.getPassword());

            String token = JWTConfig.generateToken(response,user.getGmail());
            LoginResponseDTO responseDTO = new LoginResponseDTO(token,user.getFull_name());
            session.setAttribute("name", user.getGmail());
            session.setAttribute("token", token);
            return ResponseEntity.ok(responseDTO);
        } catch (IllegalArgumentException e) {
            // Nếu có lỗi xảy ra trong quá trình đăng nhập, trả về lỗi UNAUTHORIZED
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    @GetMapping("show")
    public String hello() {
        return "Hello World";
    }


}