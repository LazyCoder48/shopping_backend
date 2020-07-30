package com.shop.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.dto.LoginUser;
import com.shop.dto.RegisterUser;
import com.shop.model.AppUsers;
import com.shop.repository.UserRepository;
import com.shop.security.JwtProvider;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private ModelMapper modelMap;

    public AppUsers signUp(RegisterUser registerUser) {
        AppUsers appUser = convertToEntity(registerUser);

        // appUser.setContactNumber(registerUser.getContactNumber());
        appUser.setUserPassword(encodePassword(registerUser.getUserPassword()));
        log.info(appUser.toString());
        userRepo.save(appUser);
        appUser.setUserPassword("");
        return appUser;
    }

    public AuthenticationResponse login(LoginUser loginUser) {
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getContactNumber(), loginUser.getUserPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginUser.getContactNumber());

    }

    /* private methods */

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);

    }

    public Optional<User> getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }

    private AppUsers convertToEntity(RegisterUser registerUser) {
        AppUsers appUser = modelMap.map(registerUser, AppUsers.class);

        return appUser;
    }

}
