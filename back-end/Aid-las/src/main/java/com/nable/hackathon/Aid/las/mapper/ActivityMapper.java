package com.nable.hackathon.Aid.las.mapper;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import com.nable.hackathon.Aid.las.data.activity.ActivityRequestData;
import com.nable.hackathon.Aid.las.data.activity.ActivityResponseData;
import com.nable.hackathon.Aid.las.entity.Activity;

import java.time.LocalDateTime;
import java.util.List;

public class ActivityMapper {
    public static ActivityResponseData toActivityResponseData(Activity activity) {
        return ActivityResponseData.builder()
            .name(activity.getName())
            .description(activity.getDescription())
            .location(activity.getLocation())
            .startTime(activity.getStartTime().toString())
            .activityTagList(activity.getActivityTagList().toString())
            .build();
    }

    public static Activity fromActivityRequestData(ActivityRequestData activityRequestData) {
        return Activity.builder()
            .name(activityRequestData.getName())
            .description(activityRequestData.getDescription())
            .location(activityRequestData.getLocation())
            .startTime(LocalDateTime.parse(activityRequestData.getStartTime()))
            .activityTagList(activityRequestData.getActivityTagList()
                .stream()
                .map(ActivityTag::valueOf).toList())
            .build();
    }
}
