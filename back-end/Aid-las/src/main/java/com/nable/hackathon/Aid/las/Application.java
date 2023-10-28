package com.nable.hackathon.Aid.las;


import com.nable.hackathon.Aid.las.common.ActivityTag;
import com.nable.hackathon.Aid.las.common.UserSex;
import com.nable.hackathon.Aid.las.entity.Activity;
import com.nable.hackathon.Aid.las.entity.Attendee;
import com.nable.hackathon.Aid.las.entity.Organizer;
import com.nable.hackathon.Aid.las.entity.User;
//import com.nable.hackathon.Aid.las.entity.auxiliary.AuxiliaryAttendeeActivity;
import com.nable.hackathon.Aid.las.repository.ActivityRepository;
import com.nable.hackathon.Aid.las.repository.AttendeeRepository;
import com.nable.hackathon.Aid.las.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
	private OrganizerRepository organizerRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private AttendeeRepository attendeeRepository;


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
		organizer.setUserSex(UserSex.MALE);
		organizer.setAge(10);
		organizer.setUsername("Organizer 1");
		organizer.setPassword("sfklgdf");

		organizerRepository.save(organizer);

		Activity activity = new Activity();
		activity.setName("Activity 1");
		activity.setDescription("Description 1");
		activity.setActivityTagList(List.of(ActivityTag.CLEANUP, ActivityTag.SENIOR_CARE));
		activity.setActivityId(1);
		//activity.setOrganizer(organizer);
		activity.setOrganizerId(1);
		activity.setLocation("Bucharest, Dorobanti, 25");
		activity.setStartTime(LocalDateTime.of(2021, 10, 10, 10, 10));
		activity.setMaxAttendees(10);
		activity.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockph");

		activityRepository.save(activity);

		activityRepository.save(
			Activity.builder()
				.activityId(2)
				.name("Activity 2")
				.description("Description 2")
				.activityTagList(List.of(ActivityTag.CLEANUP, ActivityTag.SENIOR_CARE))
				.organizerId(1)
				.location("Bucharest, Dorobanti, 25")
				.imageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockph")
				.startTime(LocalDateTime.of(2021, 10, 10, 10, 10))
				.maxAttendees(10)
				.build()
		);
		activityRepository.findById(1).ifPresent(System.out::println);

		User user = new User();
		user.setUserId(5);
		user.setUsername("User 1");
		user.setPassword("sfklgdf");

		Attendee attendee = new Attendee();
		attendee.setUserId(2);
		attendee.setAge(10);
		attendee.setUserSex(UserSex.MALE);
		attendee.setUsername("Attendee 1");
		attendee.setPassword("sfklgdf");

		attendeeRepository.save(attendee);
	}
}
