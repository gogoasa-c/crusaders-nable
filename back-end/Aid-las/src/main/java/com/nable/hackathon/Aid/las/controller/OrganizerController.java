package com.nable.hackathon.Aid.las.controller;

import com.nable.hackathon.Aid.las.data.organizer.OrganizerRequestData;
import com.nable.hackathon.Aid.las.data.organizer.OrganizerResponseData;
import com.nable.hackathon.Aid.las.entity.Organizer;
import com.nable.hackathon.Aid.las.service.OrganizerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizer")
@Slf4j
public class OrganizerController {
    @Resource
    public OrganizerService organizerService;

    @GetMapping("/{organizerId}")
    public ResponseEntity<OrganizerResponseData> getOrganizer(@PathVariable Integer organizerId) {
        log.info("Entered getOrganizer with organizerId: {}", organizerId);

        return ResponseEntity.ok(organizerService.getOrganizer(organizerId));
    }

    @PostMapping("/create")
    public ResponseEntity<OrganizerResponseData> createOrganizer(@RequestBody OrganizerRequestData organizerRequestData) {
        log.info("Entered createOrganizer");

        return ResponseEntity.ok(organizerService.createOrganizer(organizerRequestData));
    }

    @PutMapping("/{organizerId}/update")
    public ResponseEntity<OrganizerResponseData> updateOrganizer(@PathVariable Integer organizerId,
                                                                 @RequestBody OrganizerRequestData organizer) {
        log.info("Entered updateOrganizer with organizerId: {}", organizerId);

        return ResponseEntity.ok(organizerService.updateOrganizer(organizerId, organizer));
    }

    @DeleteMapping("/{organizerId}/delete")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Integer organizerId) {
        log.info("Entered deleteOrganizer with organizerId: {}", organizerId);

        organizerService.deleteOrganizer(organizerId);
        return ResponseEntity.noContent().build();
    }
}
