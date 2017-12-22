package com.nni.service.dancemeup.comtrollers;

import com.nni.service.dancemeup.entities.Profile;
import com.nni.service.dancemeup.exceptions.UserNotFoundException;
import com.nni.service.dancemeup.repositories.ProfileRepository;
import com.nni.service.dancemeup.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by magma on 12/22/2017.
 */

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository profileRepository;

    private final UserRepository userRepository;

    @Autowired
    ProfileController(ProfileRepository profileRepository, UserRepository userRepository){
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Profile getProfile(@PathVariable String userId){
        this.validateUser(userId);
        return this.profileRepository.findByUsername(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Profile> add(@PathVariable String userId,
                                @RequestBody String email){

        Profile result = profileRepository.save(new Profile(userId, email));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
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