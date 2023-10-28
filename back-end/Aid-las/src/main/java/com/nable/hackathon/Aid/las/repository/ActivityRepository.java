package com.nable.hackathon.Aid.las.repository;

import com.nable.hackathon.Aid.las.entity.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
