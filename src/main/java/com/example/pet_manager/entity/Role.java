package com.example.pet_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name", length = 50)
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Customer> customers;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Admin>  admins;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Doctor>  doctors;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Host>  hosts;


}
