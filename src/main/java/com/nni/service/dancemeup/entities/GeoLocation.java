package com.nni.service.dancemeup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class GeoLocation {
	
	public GeoLocation(){
		
	}

	@Id
	@GeneratedValue
	public Long id;
	
	private double longitude;

	private double latitude;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	@Override
	public String toString() {
		return String.format("GeoLocation [id=%s, longitude=%s, latitude=%s]", id, longitude, latitude);
	}
	
	
}