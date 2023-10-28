package com.nable.hackathon.Aid.las.data.attendee;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendeeRequestData {
    private String username;
    private String name;
    private String password;
    private Integer age;
    private String userSex;
}
