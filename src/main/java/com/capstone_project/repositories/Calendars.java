package com.capstone_project.repositories;

import com.capstone_project.models.Calendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nedwaldie on 2/27/17.
 */
@Repository
public interface Calendars extends CrudRepository<Calendar, Integer>{
}
