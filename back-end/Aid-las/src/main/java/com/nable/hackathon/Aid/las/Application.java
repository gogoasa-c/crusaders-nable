package com.nable.hackathon.Aid.las;


import com.nable.hackathon.Aid.las.common.ActivityTag;
import com.nable.hackathon.Aid.las.entity.Activity;
import com.nable.hackathon.Aid.las.entity.Organizer;
import com.nable.hackathon.Aid.las.repository.ActivityRepository;
import com.nable.hackathon.Aid.las.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
	private OrganizerRepository organizerRepository;

	@Autowired
	private ActivityRepository activityRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populateActivities();
	}

	public void populateActivities() {
		Organizer organizer = new Organizer();
		organizer.setUserId(1);
		organizer.setUsername("Organizer 1");
		organizer.setPassword("sfklgdf");

		organizerRepository.save(organizer);

		Activity activity = new Activity();
		activity.setName("Activity 1");
		activity.setActivityTagList(List.of(ActivityTag.CLEANUP, ActivityTag.SENIOR_CARE));
		activity.setActivityId(1);
		activity.setOrganizerId(1);

		activityRepository.save(activity);

		activityRepository.findById(1).ifPresent(System.out::println);
	}
}
