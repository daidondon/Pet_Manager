package com.example.pet_manager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "pet")
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

    @OneToMany(mappedBy = "pet",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<HealthHistory> healthHistory;

    @OneToMany(mappedBy = "pet",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<VacinationHistory> vacinationHistory;

    @OneToMany(mappedBy = "pet",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<CustomerPet> customerPets;
}
