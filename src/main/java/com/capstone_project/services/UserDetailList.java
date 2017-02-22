package com.capstone_project.services;

import com.capstone_project.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * Created by nedwaldie on 2/22/17.
 */
public class UserDetailList extends User {
//    private List<String> userRoles;
//
//    public UserDetailList(User user, List<String> userRoles) {
//        super(user);
//        this.userRoles = userRoles;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}

