package com.nable.hackathon.Aid.las.controller;

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
    public ResponseEntity<Attendee> getAttendee(@PathVariable Integer attendeeId) {
        log.info("Entered getAttendee with attendeeId: {}", attendeeId);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Attendee> createAttendee(@RequestBody Attendee attendee) {
        log.info("Entered createAttendee");

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{attendeeId}")
    public ResponseEntity<Attendee> updateAttendee(@PathVariable Integer attendeeId, @RequestBody Attendee attendee) {
        log.info("Entered updateAttendee with attendeeId: {} and attendee: {}", attendeeId, attendee);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<Attendee> deleteAttendee(@PathVariable Integer attendeeId) {
        log.info("Entered deleteAttendee with attendeeId: {}", attendeeId);

        // to be modified with service method call
        return ResponseEntity.noContent().build();
    }
}
