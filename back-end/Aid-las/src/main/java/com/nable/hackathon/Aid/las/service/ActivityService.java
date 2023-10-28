package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.entity.Activity;
import com.nable.hackathon.Aid.las.repository.ActivityRepository;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Service
@Slf4j
public class ActivityService {
    @Resource
    private ActivityRepository activityRepository;


}
