package com.example.pet_manager.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "link_meet")
    private String linkMeet;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "clinic_id")
    private int clinicId;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<PetRecord> petRecord;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
