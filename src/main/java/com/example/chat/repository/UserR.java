package com.example.chat.repository;

import com.example.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserR extends MongoRepository<User, String> {
    User findByUsername(String username);
    Optional<User> findById(String id);


}
