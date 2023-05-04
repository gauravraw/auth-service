package com.example.authservice.service.impl;

import com.example.authservice.entity.User;
import com.example.authservice.enumeration.ErrorCode;
import com.example.authservice.exception.GlobalException;
import com.example.authservice.nonEntity.BaseResponse;
import com.example.authservice.nonEntity.UserCreationRequestNonEntity;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Service layer of user details implementation
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final String USER_FOUND = "User name already exists in database";

    @Override
    public BaseResponse<String> createUser(UserCreationRequestNonEntity userCreationRequestNonEntity) {
        Optional<User> optionalUser = getUserByUserName(userCreationRequestNonEntity.getUserName());
        String data = "";
        if (optionalUser.isPresent()) {
            log.info("Username :: {}  already exists", userCreationRequestNonEntity.getUserName());
            data = USER_FOUND;
        } else {
            saveUser(User.builder().userName(userCreationRequestNonEntity.getUserName())
                    .password(userCreationRequestNonEntity.getPassword()).createdAt(LocalDate.now().atStartOfDay())
                    .build());
        }
        return BaseResponse.<String> builder().data(data).success(!data.equalsIgnoreCase(USER_FOUND)).build();
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        try {
            userRepository.save(user);
            log.info("Data saved successfully to database");
        } catch (Exception ex) {
            log.error("Exception occurred while saving record to database ::{}", ex.getMessage());
            throw new GlobalException(ErrorCode.EXP_001);
        }
    }

}
