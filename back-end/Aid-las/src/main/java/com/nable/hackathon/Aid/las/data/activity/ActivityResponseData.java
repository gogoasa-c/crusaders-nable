package com.nable.hackathon.Aid.las.data.activity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActivityResponseData {
    private String name;
    private String description;
    private String location;
    private String startTime;
    private String activityTagList;
}
