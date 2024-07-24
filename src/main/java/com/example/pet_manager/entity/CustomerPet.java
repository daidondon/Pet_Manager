package com.example.pet_manager.entity;

<<<<<<< HEAD
import javax.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
=======
import jakarta.persistence.*;
import lombok.*;

>>>>>>> 1c621972ee8e90c9d1c3740406349501a87ce571
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "customer_pet")
public class CustomerPet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "status")
    private String status;

    @Column(name = "owner_from_date")
    private LocalDateTime owner_from_date;
}
