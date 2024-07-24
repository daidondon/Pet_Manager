package com.example.pet_manager.entity;


import lombok.Data;

import jakarta.persistence.*;
;import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "create_by")
    private int createBy;

    @Column(name = "update_by")
    private int updateBy;

}
