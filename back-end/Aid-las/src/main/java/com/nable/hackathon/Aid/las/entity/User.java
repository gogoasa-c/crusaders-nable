package com.nable.hackathon.Aid.las.entity;

import com.nable.hackathon.Aid.las.common.UserSex;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "activityId")
    @Getter
    @Setter
    Set<Activity> activities;

    @Column
    private Integer age;

    @Column
    UserSex userSex;

    @Column
    private String email;

    public void setActivitySet(Set<Activity> activitySet) {
        this.activities = activitySet;
    }
}
