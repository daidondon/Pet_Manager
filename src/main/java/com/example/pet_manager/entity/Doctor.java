package com.example.pet_manager.entity;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<PetRecord> petRecord;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

}
