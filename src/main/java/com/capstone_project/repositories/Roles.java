package com.capstone_project.repositories;

import com.capstone_project.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nedwaldie on 2/22/17.
 */
@Repository
public interface Roles extends CrudRepository<UserRole, Integer> {
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    List<String> ofUserWith(String username);
}
