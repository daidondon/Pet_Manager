package com.example.pet_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "medicines")
public class Medicine extends BaseEntity{


    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "type")
    private String type;

    @Column(name = "trademark")
    private String trademark;

    @Column(name = "descrition")
    private String descrition;

    @OneToMany(mappedBy = "medicine",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<MedicineImage> medicineImage;

}
