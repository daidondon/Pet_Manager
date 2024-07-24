package com.example.pet_manager.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "user_pet")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @Email
    private String gmail;

    @NotBlank
    @Size(max = 50)
    private String full_name;


    @NotBlank
    @Size(max = 15)
    private String password;

    @NotBlank
    @Size(max = 255)
    private String address;


    @NotBlank
    @Size(max = 10)
    private String phone_number;

    @Size(max = 10)
    private String verify;

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    private int status;
//    @JsonIgnore
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Customer> customers;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Host> hosts;
//    @JsonIgnore
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Doctor> doctors;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Admin> admins;

}

