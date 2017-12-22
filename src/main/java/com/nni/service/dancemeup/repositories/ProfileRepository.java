package com.nni.service.dancemeup.repositories;

import com.nni.service.dancemeup.entities.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by magma on 12/21/2017.
 */

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    public Profile findByUsername(String username);


}
