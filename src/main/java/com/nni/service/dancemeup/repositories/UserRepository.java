package com.nni.service.dancemeup.repositories;

import com.nni.service.dancemeup.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by magma on 12/21/2017.
 */

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
