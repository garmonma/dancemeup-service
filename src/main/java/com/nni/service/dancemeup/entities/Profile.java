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

    private String email;

    private String firstName;

    private String lastName;



    private Location location;

    private String aboutMe;

    private String photo;

    private Status danceStatus;

    public Profile(){

    }


}
