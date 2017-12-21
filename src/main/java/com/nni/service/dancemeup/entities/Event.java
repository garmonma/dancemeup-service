package com.nni.service.dancemeup.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private Set<Profile> attendies = new HashSet<Profile>();

    private Location location;

    private Profile creator;

    private String openTo;

    private String description;
}
