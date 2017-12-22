package com.nni.service.dancemeup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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



    private Location location;

    private String aboutMe;

    private String photo;

    private Status danceStatus;

    public String getId(){
        return this.getId();
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

    public Status getDanceStatus(){
        return this.danceStatus;
    }

    public Profile(Profile profile){

        this.email = profile.getEmail();
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
        this.aboutMe = profile.getAboutMe();

    }

    public Profile(String username, String email){
        this.email = getEmail();
    }

    public Profile(){

    }


}
