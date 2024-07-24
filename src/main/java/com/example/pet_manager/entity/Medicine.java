package com.example.pet_manager.entity;

<<<<<<< HEAD
import javax.persistence.*;
=======
import jakarta.persistence.*;
>>>>>>> 1c621972ee8e90c9d1c3740406349501a87ce571
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

    @Column(name = "clinic_id")
    private Integer clinicId;

    @OneToMany(mappedBy = "medicine",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khong sử dụng trong toString()
    private List<MedicineImage> medicineImage;

}
