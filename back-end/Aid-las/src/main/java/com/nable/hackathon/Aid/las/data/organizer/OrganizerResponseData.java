package com.nable.hackathon.Aid.las.data.organizer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizerResponseData {
    private String username;
    private String name;
    private Integer age;
    private String userSex;
    private String email;
}
