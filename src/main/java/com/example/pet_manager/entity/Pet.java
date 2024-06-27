package com.example.pet_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "Pet")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "species")
    private String species;

    @Column(name = "identifying")
    private String identifying;

    @Column(name = "origin_certificate")
    private String originCertificate;

    @Column(name = "transfer_contract")
    private String transferContract;

}
