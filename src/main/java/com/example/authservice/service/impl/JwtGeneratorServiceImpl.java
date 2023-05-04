package com.example.authservice.service.impl;

import com.example.authservice.entity.User;
import com.example.authservice.service.JwtGeneratorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtGeneratorServiceImpl implements JwtGeneratorService {

    @Value(value = "${jwt.secret}")
    private String jwtSecret;

    @Value(value = "${app.jwttoken.message}")
    private String jwtMessage;

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(Date.from(Instant.now()))
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", jwtMessage);
        return jwtTokenMap;
    }
}
