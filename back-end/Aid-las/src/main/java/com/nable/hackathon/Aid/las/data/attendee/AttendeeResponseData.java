package com.nable.hackathon.Aid.las.data.attendee;

import com.nable.hackathon.Aid.las.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeResponseData {
    private String username;
    private String name;
    private Set<Activity> activitySet;
    private Integer age;
    private String userSex;
}
