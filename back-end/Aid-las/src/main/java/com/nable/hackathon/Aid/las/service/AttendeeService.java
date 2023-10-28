package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.common.UserSex;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeRequestData;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeResponseData;
import com.nable.hackathon.Aid.las.entity.Attendee;
import com.nable.hackathon.Aid.las.mapper.AttendeeMapper;
import com.nable.hackathon.Aid.las.repository.AttendeeRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
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

    public AttendeeResponseData updateActivity(Integer attendeeId, AttendeeRequestData attendeeRequestData) {
        Optional<Attendee> optionalAttendee = attendeeRepository.findById(attendeeId);

        if (optionalAttendee.isEmpty()) {
            throw new RuntimeException("Attendee not found");
        }

        Attendee attendee = optionalAttendee.get();

        if (attendeeRequestData.getUsername() != null) {
            attendee.setUsername(attendeeRequestData.getUsername());
        }

        if (attendeeRequestData.getPassword() != null) {
            attendee.setPassword(attendeeRequestData.getPassword());
        }

        if (attendeeRequestData.getActivitySet() != null) {
            attendee.setActivitySet(attendeeRequestData.getActivitySet());
        }

        if (attendeeRequestData.getAge() != null) {
            attendee.setAge(attendeeRequestData.getAge());
        }

        if (attendeeRequestData.getUserSex() != null) {
            attendee.setUserSex(UserSex.valueOf(attendeeRequestData.getUserSex()));
        }

        attendeeRepository.save(attendee);

        return AttendeeMapper.toAttendeeResponseData(attendee);
    }

    public void deleteAttendee(Integer attendeeId) {
        attendeeRepository.findById(attendeeId).
                orElseThrow(() -> new RuntimeException("Attendee not found"));

        attendeeRepository.deleteById(attendeeId);
    }

    public List<AttendeeResponseData> getAllAttendees() {
        Iterable<Attendee> attendees = attendeeRepository.findAll();
        List<Attendee> attendeeList = new ArrayList<>();
        attendees.forEach(attendeeList::add);

        return attendeeList.stream()
            .map(AttendeeMapper::toAttendeeResponseData)
            .toList();
    }
}
