package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.model.AppUsers;
import com.shop.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String contactNumber) throws UsernameNotFoundException {
        AppUsers appUser = userRepo.getUserByContactNumber(contactNumber).orElseThrow(() -> new UsernameNotFoundException("No User found with contact Number " + contactNumber));
        return new User(appUser.getContactNumber(), appUser.getUserPassword(), true, true, true, true, getAuthorities("ROLE_SHOPPER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String userRole) {
        return Collections.singletonList(new SimpleGrantedAuthority(userRole));
    }

}
