package com.nable.hackathon.Aid.las.controller;

import com.nable.hackathon.Aid.las.data.activity.ActivityRequestData;
import com.nable.hackathon.Aid.las.data.activity.ActivityResponseData;
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
    public ResponseEntity<ActivityResponseData> getActivity(@PathVariable Integer activityId) {
        log.info("Entered getActivity with activityId: {}", activityId);

        return ResponseEntity.ok(activityService.getActivity(activityId));
    }

    @PostMapping("/create")
    public ResponseEntity<ActivityResponseData> createActivity(@RequestBody ActivityRequestData activityRequestData) {
        log.info("Entered createActivity with activity: {}", activityRequestData);

        return ResponseEntity.ok(activityService.createActivity(activityRequestData)));
    }

    @PutMapping("/{activityId}/update")
    public ResponseEntity<ActivityResponseData> updateActivity(@PathVariable Integer activityId,
                                                               @RequestBody ActivityRequestData activity) {
        log.info("Entered updateActivity with activityId: {} and activity: {}", activityId, activity);

        // to be modified with service method call
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{activityId}/delete")
    public ResponseEntity<Void> deleteActivity(@PathVariable Integer activityId) {
        log.info("Entered deleteActivity with activityId: {}", activityId);

        // to be modified with service method call
        return ResponseEntity.noContent().build();
    }

}
