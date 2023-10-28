package com.nable.hackathon.Aid.las.data.attendee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeResponseData {
    private String username;
    private String name;
    private Integer age;
    private String userSex;
}
