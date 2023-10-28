package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.data.attendee.AttendeeRequestData;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeResponseData;
import com.nable.hackathon.Aid.las.entity.Attendee;
import com.nable.hackathon.Aid.las.mapper.AttendeeMapper;
import com.nable.hackathon.Aid.las.repository.AttendeeRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AttendeeService {
    @Resource
    private AttendeeRepository attendeeRepository;

    public AttendeeResponseData getAttendee(Integer attendeeId) {
        Optional<Attendee> attendee = attendeeRepository.findById(attendeeId);

        if (attendee.isEmpty()) {
            log.error("Attendee not found");
            return new AttendeeResponseData();
        }

        return AttendeeMapper.toAttendeeResponseData(attendee.get());
    }

    public AttendeeResponseData createAttendee(AttendeeRequestData attendeeRequestData) {
        Attendee attendee = AttendeeMapper.fromAttendeeRequestData(attendeeRequestData);

        if (attendeeRepository.save(attendee) == null) {
            throw new RuntimeException("Attendee not created");
        }

        return AttendeeMapper.toAttendeeResponseData(attendee);
    }
}
