package com.capstone_project.services;

import com.capstone_project.models.User;
import com.capstone_project.repositories.Roles;
import com.capstone_project.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by nedwaldie on 2/22/17.
 */
public class UserDetailsLoader {
//    private final Users users;
//    private final Roles roles;
//
//    @Autowired
//    public UserDetailsLoader(Users users, Roles roles) {
//        this.users = users;
//        this.roles = roles;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = users.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("No user found for " + email);
//        }
//
//        List<String> userRoles = roles.ofUserWith(email);
//        return new UserDetailList(user, userRoles);
//    }
}
