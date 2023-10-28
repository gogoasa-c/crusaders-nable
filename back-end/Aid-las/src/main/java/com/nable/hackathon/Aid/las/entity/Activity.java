package com.nable.hackathon.Aid.las.entity;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue
    private Integer activityId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    Set<User> attendees;

    @Column
    private String description;

    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = false)
    private String location;

    @Column
    private LocalDateTime startTime;

    @Column
    List<ActivityTag> activityTagList;

    /*@ManyToOne
    @JoinColumn(name = "organizerId")
    private Organizer organizer;*/

    @Column(nullable = false)
    private Integer organizerId;

    @Column
    private Integer maxAttendees;
}
