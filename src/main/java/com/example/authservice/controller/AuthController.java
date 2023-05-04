package com.example.authservice.controller;

import com.example.authservice.entity.User;
import com.example.authservice.enumeration.ErrorCode;
import com.example.authservice.exception.GlobalException;
import com.example.authservice.nonEntity.BaseResponse;
import com.example.authservice.nonEntity.UserCreationRequestNonEntity;
import com.example.authservice.service.JwtGeneratorService;
import com.example.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;

    private final JwtGeneratorService jwtGeneratorService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<String>> saveUser(
            @RequestBody UserCreationRequestNonEntity userCreationRequestNonEntity) {
        return ResponseEntity.ok(userService.createUser(userCreationRequestNonEntity));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserCreationRequestNonEntity user) {
        try {
            if (user.getUserName() == null || user.getPassword() == null) {
                throw new InvalidParameterException();
            }
            Optional<User> optionalUser = userService.getUserByUserName(user.getUserName());
            if (!optionalUser.isPresent()) {
                throw new GlobalException();
            }
            return ResponseEntity.ok(jwtGeneratorService.generateToken(optionalUser.get()));
        } catch (InvalidParameterException invalidParameterException) {
            log.error("Invalid parameter for request :: {}", invalidParameterException.getMessage());
            throw new GlobalException(ErrorCode.EXP_002);
        } catch (GlobalException globalException) {
            log.error("User not present for request");
            throw new GlobalException(ErrorCode.EXP_003);
        }
    }
}
