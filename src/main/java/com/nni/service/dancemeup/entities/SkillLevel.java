package com.nni.service.dancemeup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by magma on 12/21/2017.
 */

@Entity
public class SkillLevel {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
}
