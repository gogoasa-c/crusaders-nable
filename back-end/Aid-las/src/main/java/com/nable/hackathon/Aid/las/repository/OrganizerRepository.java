package com.nable.hackathon.Aid.las.repository;

import com.nable.hackathon.Aid.las.entity.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {

}
