package com.nable.hackathon.Aid.las.entity;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Activity {

    @Id
    private Integer activityId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    List<ActivityTag> activityTagList;

    @Column(nullable = false)
    private Integer organizerId;

    @Column
    private Integer maxAttendees;

}
