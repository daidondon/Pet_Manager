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

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Customer> customers;
}
