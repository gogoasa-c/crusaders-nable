package com.nable.hackathon.Aid.las.entity.auxiliary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(AttendeeActivityId.class)
public class AttendeeActivity {

    @Id
    private Integer attendeeId;
    @Id
    private Integer activityId;
}
