package com.example.authservice.repository;

import com.example.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Method returns existing username
     * 
     * @param userName
     *            is used as parameter
     * @return a user object
     */
    public Optional<User> findByUserName(String userName);
}
