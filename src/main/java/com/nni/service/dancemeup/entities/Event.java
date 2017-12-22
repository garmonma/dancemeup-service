package com.nni.service.dancemeup.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    @JsonIgnore
    @ManyToMany()
    private Set<Profile> profiles = new HashSet<Profile>();

    private String location;

    private String creator;

    private String openTo;

    private String description;
}
