package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.repository.AttendeeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    @Resource
    private AttendeeRepository attendeeRepository;
}
