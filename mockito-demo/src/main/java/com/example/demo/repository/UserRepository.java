package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.Optional;

public interface UserRepository {
    // In a real app, Spring Data JPA would implement this automatically
    Optional<User> findById(Long id);
}