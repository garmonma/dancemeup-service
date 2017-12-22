package com.nni.service.dancemeup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class Location {
	
	@Id
	@GeneratedValue
	public Long id;

	private double longitude;
	private double latitude;
	
	public Location(){
		
	}
}
