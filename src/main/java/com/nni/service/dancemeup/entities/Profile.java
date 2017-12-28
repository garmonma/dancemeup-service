package com.nni.service.dancemeup.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.minidev.json.JSONObject;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class Profile {


    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="id")
    private GeoLocation location;

    private String aboutMe;
    
    private String gender;
    
    private String dances;

    private String photo;

    private String danceStatus;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "profiles")
    private Set<Event> events = new HashSet<Event>();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
    public String getDances(){
        return this.dances;
    }
    
    public String getGender(){
        return this.gender;
    }
    

    public String getPhoto(){
        return this.photo;
    }

    public String getDanceStatus(){
        return this.danceStatus;
    }
    
    public GeoLocation getLocation(){
    	return this.location;
    }


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLocation(GeoLocation location) {
		this.location = location;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDances(String dances) {
		this.dances = dances;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setDanceStatus(String danceStatus) {
		this.danceStatus = danceStatus;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	

	public Profile(Profile profile){

        this.email = profile.getEmail();
        //this.firstName = profile.getFirstName();
       // this.lastName = profile.getLastName();
       // this.aboutMe = profile.getAboutMe();
        this.gender = profile.getGender();
        this.dances = profile.getDances();

    }

    public Profile(String username, String email){
        this.email = email;
    }

    public Profile(){

    }

	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format(
				"Profile [id=%s, nickname=%s, email=%s, firstName=%s, lastName=%s, location=%s, aboutMe=%s, gender=%s, dances=%s, photo=%s, danceStatus=%s, events=%s]",
				id, nickname, email, firstName, lastName, location, aboutMe, gender, dances, photo, danceStatus,
				events != null ? toString(events, maxLen) : null);
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
}