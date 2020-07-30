package com.shop.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.LoginUser;
import com.shop.dto.RegisterUser;
import com.shop.model.AppUsers;
import com.shop.service.AuthService;
import com.shop.service.AuthenticationResponse;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/auth")
@Log4j2
public class AuthController {

    @Autowired
    private AuthService auth;

    @PostMapping("/signUp")
    public ResponseEntity<AppUsers> signUp(@RequestBody RegisterUser registerUser) {
        log.info("Registering a user : " + registerUser.toString());
        AppUsers appUser = auth.signUp(registerUser);
        log.info("User: " + appUser.getContactNumber() + " is registered");
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginUser loginUser) {
        log.warn("Attempting Login for user: " + loginUser.getContactNumber());
        AuthenticationResponse authResponse = auth.login(loginUser);
        log.info(authResponse.getUsername() + " is authenticated with user token: " + authResponse.getAuthenticationToken());
        return authResponse;

    }
}
