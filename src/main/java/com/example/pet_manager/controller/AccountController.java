package com.example.pet_manager.controller;

import com.example.pet_manager.entity.User;
import com.example.pet_manager.request.EmailDetails;
import com.example.pet_manager.response.AccountResponseForAdmin;
import com.example.pet_manager.service.CustomerService;
import com.example.pet_manager.service.UserService;
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
}
