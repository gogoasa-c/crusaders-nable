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
import java.util.Set;

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
		organizer.setEmail("asdsad@sda");

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
		user.setEmail("asdsa@asdsa");

		Attendee attendee = new Attendee();
		attendee.setUserId(2);
		attendee.setAge(10);
		attendee.setUserSex(UserSex.MALE);
		attendee.setUsername("Attendee 1");
		attendee.setPassword("sfklgdf");
		attendee.setEmail("zzzz@ssss");

		attendeeRepository.save(attendee);

		//hardcodare populare activitati/evenimente
		Organizer organizer1 = new Organizer();
		organizer1.setUserId(10);
		organizer1.setUsername("Marian Dumitrescu");
		organizer1.setPassword("parola10");
		organizer1.setAge(40);
		organizer1.setUserSex(UserSex.MALE);
		organizer1.setEmail("dummar@yahoo.com");

		organizerRepository.save(organizer1);

		Organizer organizer2 = new Organizer();
		organizer2.setUserId(11);
		organizer2.setUsername("Maria Popescu");
		organizer2.setPassword("parola11");
		organizer2.setAge(33);
		organizer2.setUserSex(UserSex.FEMALE);
		organizer2.setEmail("mariamaripop@gmail.com");

		organizerRepository.save(organizer2);

		Attendee attendee1 = new Attendee();
		attendee1.setUserId(100);
		attendee1.setUsername("Dorin Miron");
		attendee1.setPassword("parola100");
		attendee1.setAge(18);
		attendee1.setUserSex(UserSex.MALE);
		attendee1.setEmail("dorinmiron@yahoo.com");

		attendeeRepository.save(attendee1);

		Attendee attendee2 = new Attendee();
		attendee2.setUserId(101);
		attendee2.setUsername("Alina Florescu");
		attendee2.setPassword("parola101");
		attendee2.setAge(24);
		attendee2.setUserSex(UserSex.FEMALE);
		attendee2.setEmail("alinaFLO@gmail.com");

		attendeeRepository.save(attendee2);

		Activity activity1 = new Activity();
		activity1.setActivityId(10);
		activity1.setName("Plantare flori exotice");
		activity1.setAttendees(Set.of(attendee1, attendee2));
		activity1.setDescription("Impreuna cu 2 experti gradinari vom planta 11 tipuri diferite de " +
				"flori exotice adunate din Europa, Asia, Australia si America de Sud.");
		activity1.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/8/87/Exotic_Flowers.jpg");
		activity1.setLocation("Bucuresti, Gradina Botanica");
		activity1.setStartTime(LocalDateTime.of(2023, 11, 7, 8, 30));
		activity1.setActivityTagList(List.of(ActivityTag.PLANTING));
		activity1.setOrganizerId(10);
		activity1.setMaxAttendees(100);

		activityRepository.save(activity1);

		Activity activity2 = new Activity();
		activity2.setActivityId(11);
		activity2.setName("Curatenie in parcul Herastrau");
		activity2.setAttendees(Set.of(attendee1, attendee2));
		activity2.setDescription("Vom curata parcul Herastrau de gunoaie");
		activity2.setImageUrl("https://en.wikipedia.org/wiki/King_Michael_I_Park#/media/File:Parcul_Herastrau_park_lake_Bucharest_Bucuresti_Romania_2.JPG");
		activity2.setLocation("Bucuresti, Parcul Herastrau");
		activity2.setStartTime(LocalDateTime.of(2023, 11, 10, 10, 0));
		activity2.setActivityTagList(List.of(ActivityTag.CLEANUP));
		activity2.setOrganizerId(11);
		activity2.setMaxAttendees(50);

		activityRepository.save(activity2);

		organizer1.setActivities(Set.of(activity1));
		organizer2.setActivities(Set.of(activity2));

		organizerRepository.save(organizer1);
		organizerRepository.save(organizer2);
	}
}
