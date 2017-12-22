package com.nni.service.dancemeup.repositories;

import com.nni.service.dancemeup.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by magma on 12/21/2017.
 */

public interface EventRepository extends JpaRepository<Event, Long> {
}
