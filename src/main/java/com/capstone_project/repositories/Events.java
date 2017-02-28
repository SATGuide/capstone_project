package com.capstone_project.repositories;

import com.capstone_project.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nedwaldie on 2/28/17.
 */
@Repository
public interface Events extends CrudRepository<Event, Integer> {
}
