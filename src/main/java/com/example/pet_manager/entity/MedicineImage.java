package com.example.pet_manager.entity;

<<<<<<< HEAD
import javax.persistence.*;
=======
import jakarta.persistence.*;
>>>>>>> 1c621972ee8e90c9d1c3740406349501a87ce571
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "medicine_image")
public class MedicineImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

}
