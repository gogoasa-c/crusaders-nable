package com.nable.hackathon.Aid.las.repository;

import com.nable.hackathon.Aid.las.entity.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends CrudRepository<Attendee, Integer> {
}
