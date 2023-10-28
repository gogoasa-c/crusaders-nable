package com.nable.hackathon.Aid.las.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Set;


@Entity
public class Organizer extends User {
    /*@OneToMany
    @JoinColumn(name = "activityId")
    Set<Activity> activities;*/
}
