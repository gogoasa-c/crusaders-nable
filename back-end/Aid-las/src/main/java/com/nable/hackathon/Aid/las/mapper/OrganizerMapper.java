package com.nable.hackathon.Aid.las.mapper;

import com.nable.hackathon.Aid.las.common.UserSex;
import com.nable.hackathon.Aid.las.data.organizer.OrganizerRequestData;
import com.nable.hackathon.Aid.las.data.organizer.OrganizerResponseData;
import com.nable.hackathon.Aid.las.entity.Organizer;

public class OrganizerMapper {
    public static OrganizerResponseData toOrganizerResponseData(Organizer organizer) {
        return OrganizerResponseData.builder()
                .username(organizer.getUsername())
                .age(organizer.getAge())
                .userSex(organizer.getUserSex().toString())
                .email(organizer.getEmail())
                .build();
    }

    public static Organizer fromOrganizerRequestData(OrganizerRequestData organizerRequestData) {
        Organizer organizer = new Organizer();

        organizer.setAge(organizerRequestData.getAge());
        organizer.setUsername(organizerRequestData.getUsername());
        organizer.setPassword(organizerRequestData.getPassword());
        organizer.setUserSex(UserSex.valueOf(organizerRequestData.getUserSex().toUpperCase()));

        return organizer;
    }
}
