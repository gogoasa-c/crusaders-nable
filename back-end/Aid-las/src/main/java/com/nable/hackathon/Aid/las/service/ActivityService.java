package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import com.nable.hackathon.Aid.las.data.activity.ActivityRequestData;
import com.nable.hackathon.Aid.las.data.activity.ActivityResponseData;
import com.nable.hackathon.Aid.las.entity.Activity;
import com.nable.hackathon.Aid.las.mapper.ActivityMapper;
import com.nable.hackathon.Aid.las.repository.ActivityRepository;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
@Slf4j
public class ActivityService {
    @Resource
    private ActivityRepository activityRepository;

    public ActivityResponseData getActivity(Integer activityId) {
        Optional<Activity> activity = activityRepository.findById(activityId);

        if (activity.isEmpty()) {
            log.error("Activity not found");
            return new ActivityResponseData();
        }

        return ActivityMapper.toActivityResponseData(activity.get());
    }

    public ActivityResponseData createActivity(ActivityRequestData activityRequestData) {
        Activity activity = ActivityMapper.fromActivityRequestData(activityRequestData);

        if (activityRepository.save(activity) == null) {
            throw new RuntimeException("Activity not created");
        }

        return ActivityMapper.toActivityResponseData(activity);
    }

    public ActivityResponseData updateActivity(Integer activityId, ActivityRequestData activityRequestData) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);

        if (optionalActivity.isEmpty()) {
            throw new RuntimeException("Activity not found");
        }

        Activity activity = optionalActivity.get();

        if (activityRequestData.getName() != null) {
            activity.setName(activityRequestData.getName());
        }

        if (activityRequestData.getDescription() != null) {
            activity.setDescription(activityRequestData.getDescription());
        }

        if (activityRequestData.getLocation() != null) {
            activity.setLocation(activityRequestData.getLocation());
        }

        if (activityRequestData.getStartTime() != null) {
            activity.setStartTime(activityRequestData.getStartTime());
        }

        if (activityRequestData.getActivityTagList() != null) {
            activity.setActivityTagList(activityRequestData.getActivityTagList()
                .stream()
                .map(ActivityTag::valueOf)
                .toList());
        }

        if (activityRequestData.getOrganizerId() != null) {
            activity.setOrganizerId(activityRequestData.getOrganizerId());
        }

        if (activityRequestData.getOrganizerId() != null) {
            activity.setOrganizerId(activityRequestData.getOrganizerId());
        }

        activityRepository.save(activity);

        return ActivityMapper.toActivityResponseData(activity);
    }

    public void deleteActivity(Integer activityId) {
        activityRepository.findById(activityId)
            .orElseThrow(() -> new RuntimeException("Activity not found"));

        activityRepository.deleteById(activityId);
    }

    public List<ActivityResponseData> getAllActivities() {
        Iterable<Activity> activities = activityRepository.findAll();
        List<Activity> activityList = new ArrayList<>();
        activities.forEach(activityList::add);

        return activityList.stream()
            .map(ActivityMapper::toActivityResponseData)
            .toList();
    }
}
