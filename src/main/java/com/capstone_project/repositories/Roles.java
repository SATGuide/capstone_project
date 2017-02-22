package com.capstone_project.repositories;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nedwaldie on 2/22/17.
 */
public interface Roles {
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}
