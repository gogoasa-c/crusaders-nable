package com.nable.hackathon.Aid.las.controller;

import com.nable.hackathon.Aid.las.entity.Activity;
import com.nable.hackathon.Aid.las.service.ActivityService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activity")
@Slf4j
public class ActivityController {
    @Resource
    public ActivityService activityService;

    @GetMapping("/{activityId}")
    public ResponseEntity<Activity> getActivity(@PathVariable Integer activityId) {
        log.info("Entered getActivity with activityId: {}", activityId);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        log.info("Entered createActivity with activity: {}", activity);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{activityId}/update")
    public ResponseEntity<Activity> updateActivity(@PathVariable Integer activityId, @RequestBody Activity activity) {
        log.info("Entered updateActivity with activityId: {} and activity: {}", activityId, activity);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{activityId}/delete")
    public ResponseEntity<Activity> deleteActivity(@PathVariable Integer activityId) {
        log.info("Entered deleteActivity with activityId: {}", activityId);

        // to be modified with service method call
        return ResponseEntity.noContent().build();
    }

}
