package com.nable.hackathon.Aid.las.data.activity;

import com.nable.hackathon.Aid.las.common.ActivityTag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActivityRequestData {
    private String name;
    private String description;
    private String location;
    private LocalDateTime startTime;
    private List<String> activityTagList;
    private Integer organizerId;
}
