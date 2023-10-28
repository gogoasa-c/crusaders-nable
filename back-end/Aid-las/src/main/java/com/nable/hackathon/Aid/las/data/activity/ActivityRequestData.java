package com.nable.hackathon.Aid.las.data.activity;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import lombok.Data;

import java.util.List;

@Data
public class ActivityRequestData {
    private String name;
    private String description;
    private String location;
    private String startTime;
    private String activityTagList;
    private Integer organizerId;
}
