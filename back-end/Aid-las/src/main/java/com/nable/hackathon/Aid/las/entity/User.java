package com.nable.hackathon.Aid.las.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;



}
