package com.nable.hackathon.Aid.las.entity;

import com.nable.hackathon.Aid.las.common.UserSex;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private Integer age;

    @Column
    UserSex userSex;


}
