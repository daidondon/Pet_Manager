package com.example.pet_manager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
}
