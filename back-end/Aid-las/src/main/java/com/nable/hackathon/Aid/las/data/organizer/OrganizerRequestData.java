package com.nable.hackathon.Aid.las.data.organizer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizerRequestData {
    private String username;
    private String name;
    private String password;
    private Integer age;
    private String userSex;
}
