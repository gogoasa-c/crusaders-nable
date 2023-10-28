package com.nable.hackathon.Aid.las.controller;

import com.nable.hackathon.Aid.las.data.attendee.AttendeeRequestData;
import com.nable.hackathon.Aid.las.data.attendee.AttendeeResponseData;
import com.nable.hackathon.Aid.las.entity.Attendee;
import com.nable.hackathon.Aid.las.service.AttendeeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendee")
@Slf4j
public class AttendeeController {
    @Resource
    public AttendeeService attendeeService;
    @GetMapping("/{attendeeId}")
    public ResponseEntity<AttendeeResponseData> getAttendee(@PathVariable Integer attendeeId) {
        log.info("Entered getAttendee with attendeeId: {}", attendeeId);

        // to be modified with service method call
        return ResponseEntity.ok(attendeeService.getAttendee(attendeeId));
    }

    @PostMapping("/create")
    public ResponseEntity<AttendeeResponseData> createAttendee(@RequestBody AttendeeRequestData attendeeRequestData) {
        log.info("Entered createAttendee");

        // to be modified with service method call
        return ResponseEntity.ok(attendeeService.createAttendee(attendeeRequestData));
    }

    @PutMapping("/{attendeeId}")
    public ResponseEntity<AttendeeResponseData> updateAttendee(@PathVariable Integer attendeeId,
                                                               @RequestBody AttendeeRequestData attendee) {
        log.info("Entered updateAttendee with attendeeId: {} and attendee: {}", attendeeId, attendee);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Integer attendeeId) {
        log.info("Entered deleteAttendee with attendeeId: {}", attendeeId);

        // to be modified with service method call
        return ResponseEntity.noContent().build();
    }
}
