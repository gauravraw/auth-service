package com.example.authservice.service;

import com.example.authservice.entity.User;
import com.example.authservice.nonEntity.BaseResponse;
import com.example.authservice.nonEntity.UserCreationRequestNonEntity;

import java.util.Optional;

public interface UserService {

    /**
     * created_by= gauravraw
     * 
     * @param userCreationRequestNonEntity
     *            contains userName and password
     * @return base response of string after successfully creating a user
     */
    BaseResponse<String> createUser(UserCreationRequestNonEntity userCreationRequestNonEntity);

    /**
     * created_by= gauravraw
     * 
     * @param userName
     *            contains userName
     * @return optional entity of user type
     */
    Optional<User> getUserByUserName(String userName);

    /**
     * created_by= gauravraw
     * 
     * @param user
     *            contains user object does not return anything
     */
    void saveUser(User user);

}
