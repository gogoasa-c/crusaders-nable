package com.nable.hackathon.Aid.las.controller;

import com.nable.hackathon.Aid.las.data.organizer.OrganizerRequestData;
import com.nable.hackathon.Aid.las.data.organizer.OrganizerResponseData;
import com.nable.hackathon.Aid.las.entity.Organizer;
import com.nable.hackathon.Aid.las.service.OrganizerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizer")
@Slf4j
public class OrganizerController {
    public OrganizerService organizerService;

    @GetMapping("/{organizerId}")
    public ResponseEntity<OrganizerResponseData> getOrganizer(@PathVariable Integer organizerId) {
        log.info("Entered getOrganizer with organizerId: {}", organizerId);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @GetMapping("/create")
    public ResponseEntity<OrganizerResponseData> createOrganizer() {
        log.info("Entered createOrganizer");

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{organizerId}/update")
    public ResponseEntity<OrganizerResponseData> updateOrganizer(@PathVariable Integer organizerId,
                                                                 @RequestBody OrganizerRequestData organizer) {
        log.info("Entered updateOrganizer with organizerId: {}", organizerId);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{organizerId}/delete")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Integer organizerId) {
        log.info("Entered deleteOrganizer with organizerId: {}", organizerId);

        // to be modified with service method call
        return ResponseEntity.noContent().build();
    }
}
