package com.nable.hackathon.Aid.las.entity.auxiliary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Entity
@Data
@IdClass(AttendeeActivityId.class)
public class AttendeeActivity {

    @Id
    private Integer attendeeId;
    @Id
    private Integer activityId;
}
