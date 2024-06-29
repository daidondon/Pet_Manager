package com.example.pet_manager.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "[User]",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "gmail")
        })
@Getter
@Setter
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

    @NotBlank
    @Size(max = 10)
    private String verify;

    private int status;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Customer> customers;
}

