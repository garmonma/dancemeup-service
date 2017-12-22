package com.nni.service.dancemeup.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class Profile {


    @Id
    @GeneratedValue
    private Long Id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String location;

    private String aboutMe;

    private String photo;

    private String danceStatus;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "profiles")
    private Set<Event> events = new HashSet<Event>();

    public Long getId(){
        return Id;
    }

    public String getEmail(){
        return this.email;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAboutMe(){
        return this.aboutMe;
    }

    public String photo(){
        return this.photo;
    }

    public String getDanceStatus(){
        return this.danceStatus;
    }

    public Profile(Profile profile){

        this.email = profile.getEmail();
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
        this.aboutMe = profile.getAboutMe();

    }

    public Profile(String username, String email){
        this.email = email;
    }

    public Profile(){

    }


}
