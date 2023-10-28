package com.nable.hackathon.Aid.las.mapper;

import com.nable.hackathon.Aid.las.common.UserSex;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeRequestData;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeResponseData;
import com.nable.hackathon.Aid.las.entity.Attendee;

public class AttendeeMapper {

    public static AttendeeResponseData toAttendeeResponseData(Attendee attendee) {
        return AttendeeResponseData.builder()
                .username(attendee.getUsername())
                .age(attendee.getAge())
                .userSex(attendee.getUserSex().toString())
                .build();
    }

    public static Attendee fromAttendeeRequestData(AttendeeRequestData attendeeRequestData) {
        Attendee attendee = new Attendee();

        attendee.setAge(attendeeRequestData.getAge());
        attendee.setUsername(attendeeRequestData.getUsername());
        attendee.setPassword(attendeeRequestData.getPassword());
        attendee.setUserSex(UserSex.valueOf(attendeeRequestData.getUserSex()));

        return attendee;
    }
}
