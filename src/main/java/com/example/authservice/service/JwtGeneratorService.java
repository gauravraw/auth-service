package com.example.authservice.service;

import com.example.authservice.entity.User;

import java.util.Map;

public interface JwtGeneratorService {

    /**
     * author gauravraw
     * 
     * @param user
     *            contains user object
     * @return a map of jwt token
     */
    Map<String, String> generateToken(User user);
}
