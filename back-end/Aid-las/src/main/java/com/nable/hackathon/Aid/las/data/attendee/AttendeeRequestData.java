package com.nable.hackathon.Aid.las.data.attendee;

import com.nable.hackathon.Aid.las.entity.Activity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AttendeeRequestData {
    private String username;
    private String name;
    private String password;
    private Set<Activity> activitySet;
    private Integer age;
    private String userSex;
}
