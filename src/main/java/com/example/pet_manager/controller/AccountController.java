package com.example.pet_manager.controller;

import com.example.pet_manager.dto.RegisterDto;
import com.example.pet_manager.entity.Clinic;
import com.example.pet_manager.entity.Host;
import com.example.pet_manager.entity.Role;
import com.example.pet_manager.entity.User;
import com.example.pet_manager.request.CreateHostAccountRequest;
import com.example.pet_manager.request.EmailDetails;
import com.example.pet_manager.response.AccountResponseForAdmin;
import com.example.pet_manager.service.ClinicService;
import com.example.pet_manager.service.CustomerService;
import com.example.pet_manager.service.HostService;
import com.example.pet_manager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/account")
@RestController
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private HostService hostService;
    @Autowired
    private ClinicService clinicService;
    @GetMapping("list-account")
    public ResponseEntity<List<AccountResponseForAdmin>> ListAccount() {
        try {

            return new ResponseEntity<>(userService.listAllAcountForAdmin(), HttpStatus.OK);



        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("ban-account")
    public ResponseEntity<String> BanAccount(@RequestParam String email) {
        try {
            User u = userService.findUserByGmail(email);
            u.setStatus(0);
            userService.updateUser(u);
            return new ResponseEntity<>("Ban success", HttpStatus.OK);



        } catch (Exception e) {
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("active-account")
    public ResponseEntity<String> ActiveAccount(@RequestParam String email) {
        try {
            User u = userService.findUserByGmail(email);
            u.setStatus(1);
            userService.updateUser(u);
            return new ResponseEntity<>("Active success", HttpStatus.OK);



        } catch (Exception e) {
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PostMapping("create-host-account")
    public ResponseEntity<String> register(@RequestBody @Valid CreateHostAccountRequest request) {
        try {
            if (userService.isExistEmail(request.getGmail())) {
                return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
            }
            User user = new User();
            user.setGmail(request.getGmail());
            user.setPassword(request.getPassword());
            user.setPhone_number(request.getPhone_number());
            user.setFull_name(request.getFull_name());
            user.setAddress(request.getAddress());
            user.setStatus(1);
            User newUser = userService.addNewUser(user);
            Host host = new Host();
            Role role = new Role();
            role.setId(2);
            role.setName("host");
            host.setRole(role);
            host.setUser(user);
            Host newHost = hostService.addHost(host);
            Clinic clinic = new Clinic();
            clinic.setHost(newHost);
            clinic.setName(request.getName_clinic());
            clinic.setAddress(request.getAddress_clinic());
            clinicService.addClinic(clinic);


            return new ResponseEntity<>("Add new host account successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
