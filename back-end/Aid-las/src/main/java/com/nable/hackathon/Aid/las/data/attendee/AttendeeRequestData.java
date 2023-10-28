package com.nable.hackathon.Aid.las.data.attendee;

import lombok.Data;

@Data
public class AttendeeRequestData {
    private String username;
    private String name;
    private String password;
    private Integer age;
    private String userSex;
}
