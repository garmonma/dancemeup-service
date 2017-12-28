package com.nni.service.dancemeup.controllers;

import com.nni.service.dancemeup.entities.Profile;
import com.nni.service.dancemeup.exceptions.UserNotFoundException;
import com.nni.service.dancemeup.repositories.ProfileRepository;
import com.nni.service.dancemeup.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by magma on 12/22/2017.
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfileController {

    private final ProfileRepository profileRepository;

    private final UserRepository userRepository;

    @Autowired
    ProfileController(ProfileRepository profileRepository, UserRepository userRepository){
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    Profile getProfile(@PathVariable String userId){
        this.validateUser(userId);
        return this.profileRepository.findByNickname(userId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/profiles")
    Collection<Profile> getProfiles(){
        return this.profileRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/profile")
    Profile add(@RequestBody Profile profile){

    	System.out.println(profile);
    	
        Profile result = profileRepository.save(profile);

        return result;
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/profile")
    Profile update(@RequestBody Profile profile){
    	System.out.println("Update Profile : " + profile);

    	Profile result= profileRepository.save(profile);
        return result;
    }

    private void validateUser(String userId) {
        if(this.userRepository.findByUsername(userId) == null) {
            try {
                throw new UserNotFoundException(userId);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}