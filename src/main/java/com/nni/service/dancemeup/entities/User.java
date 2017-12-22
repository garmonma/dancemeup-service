package com.nni.service.dancemeup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    private String password;

    private String username;
    
    public Long getId(){
    	return this.Id;
    }
    
    public String getUsername(){
    	return username;
    }
    
    public String getPassword(){
    	return password;
    }
    
    public User(User user){
    	this.username = user.getUsername();
    	this.password = user.getPassword();
    }

    public User(){

    }
}
