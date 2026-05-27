package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection is highly recommended for Spring dependencies
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserFullName(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFirstName() + " " + user.getLastName();
        } else {
            throw new IllegalArgumentException("User not found for ID: " + userId);
        }
    }
}