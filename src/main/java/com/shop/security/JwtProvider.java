package com.shop.security;

import java.security.Key;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class JwtProvider {

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(principal.getUsername()).signWith(key).compact();
    }

    public boolean validateToken(String jwt) {
        log.info(jwt);
        log.info(key.toString());
        Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
        return true;
    }

    public String getUserNameFromJwt(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }

}
