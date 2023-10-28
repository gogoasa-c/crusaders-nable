package com.nable.hackathon.Aid.las.service;

import com.nable.hackathon.Aid.las.common.UserSex;
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

    public OrganizerResponseData updateOrganizer(Integer organizerId, OrganizerRequestData organizerRequestData) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(organizerId);

        if (optionalOrganizer.isEmpty()) {
            throw new RuntimeException("Organizer not found");
        }

        Organizer organizer = optionalOrganizer.get();

        if (organizerRequestData.getUsername() != null) {
            organizer.setUsername(organizerRequestData.getUsername());
        }

        if (organizerRequestData.getPassword() != null) {
            organizer.setPassword(organizerRequestData.getPassword());
        }

        if (organizerRequestData.getAge() != null) {
            organizer.setAge(organizerRequestData.getAge());
        }

        if (organizerRequestData.getUserSex() != null) {
            if (organizerRequestData.getUsername().equals("MALE")) {
                organizer.setUserSex(UserSex.MALE);
            } else if (organizerRequestData.getUserSex().equals("FEMALE")) {
                organizer.setUserSex(UserSex.FEMALE);
            }
        }

        if (organizerRequestData.getEmail() != null) {
            organizer.setEmail(organizerRequestData.getEmail());
        }

        organizerRepository.save(organizer);

        return OrganizerMapper.toOrganizerResponseData(organizer);
    }

    public void deleteOrganizer(Integer organizerId) {
        if (!organizerRepository.existsById(organizerId)) {
            throw new RuntimeException("Organizer not found");
        }

        organizerRepository.deleteById(organizerId);
    }
}
