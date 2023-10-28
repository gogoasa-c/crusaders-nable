package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.data.organizer.OrganizerRequestData;
import com.nable.hackathon.Aid.las.data.organizer.OrganizerResponseData;
import com.nable.hackathon.Aid.las.entity.Organizer;
import com.nable.hackathon.Aid.las.mapper.OrganizerMapper;
import com.nable.hackathon.Aid.las.repository.OrganizerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizerService {

    @Resource
    private OrganizerRepository organizerRepository;

    public OrganizerResponseData getOrganizer(Integer organizerId) {
        Optional<Organizer> organizerOptional = organizerRepository.findById(organizerId);

        if (organizerOptional.isEmpty()) {
            throw new RuntimeException("Organizer not found");
        }

        return OrganizerMapper.toOrganizerResponseData(organizerOptional.get());
    }

    public OrganizerResponseData createOrganizer(OrganizerRequestData organizerRequestData) {
        Organizer organizer = OrganizerMapper.fromOrganizerRequestData(organizerRequestData);

        if (organizerRepository.save(organizer) == null) {
            throw new RuntimeException("Organizer not created");
        }

        return OrganizerMapper.toOrganizerResponseData(organizer);
    }
}
