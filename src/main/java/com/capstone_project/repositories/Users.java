package com.capstone_project.repositories;

import com.capstone_project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nedwaldie on 2/20/17.
 */
@Repository
public interface Users extends CrudRepository<User, Integer>{
    public User findByUsername(String username);
}
