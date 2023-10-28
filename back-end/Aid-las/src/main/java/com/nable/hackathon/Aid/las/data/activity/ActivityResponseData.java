package com.nable.hackathon.Aid.las.data.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponseData {
    private String name;
    private String description;
    private String imageUrl;
    private String location;
    private String startTime;
    private String activityTagList;
}
