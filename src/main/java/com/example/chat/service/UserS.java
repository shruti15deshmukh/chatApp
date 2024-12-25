package com.example.chat.service;

import com.example.chat.model.User;
import com.example.chat.repository.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserS {
    @Autowired
    private UserR userR;
    public User getUserById(String userId) {
        Optional<User> userOptional = userR.findById(userId);
        return userOptional.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userR.findByUsername(username);
    }

    public User saveUser(User user) {
        return userR.save(user);
    }

    public void updateUserStatus(String userId, boolean isOnline) {
        User user = userR.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setOnline(isOnline);
        user.setLastSeen(System.currentTimeMillis());
        userR.save(user);
    }


}
