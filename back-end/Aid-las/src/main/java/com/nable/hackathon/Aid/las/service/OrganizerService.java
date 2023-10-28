package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.repository.OrganizerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {

    @Resource
    private OrganizerRepository organizerRepository;
}
