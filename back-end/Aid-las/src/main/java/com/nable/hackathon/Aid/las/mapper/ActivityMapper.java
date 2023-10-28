package com.nable.hackathon.Aid.las.mapper;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import com.nable.hackathon.Aid.las.data.activity.ActivityRequestData;
import com.nable.hackathon.Aid.las.data.activity.ActivityResponseData;
import com.nable.hackathon.Aid.las.entity.Activity;


public class ActivityMapper {
    public static ActivityResponseData toActivityResponseData(Activity activity) {
        return ActivityResponseData.builder()
            .name(activity.getName())
            .description(activity.getDescription())
            .imageUrl(activity.getImageUrl())
            .location(activity.getLocation())
            .startTime(activity.getStartTime().toString())
            .activityTagList(activity.getActivityTagList().toString())
            .build();
    }

    public static Activity fromActivityRequestData(ActivityRequestData activityRequestData) {
        return Activity.builder()
            .name(activityRequestData.getName())
            .description(activityRequestData.getDescription())
            .imageUrl(activityRequestData.getImageUrl())
            .location(activityRequestData.getLocation())
            .startTime(activityRequestData.getStartTime())
            .organizerId(activityRequestData.getOrganizerId())
            .activityTagList(activityRequestData.getActivityTagList()
                .stream()
                .map(ActivityTag::valueOf).toList())
            .build();
    }
}
