package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Mock the dependency
    @Mock
    private UserRepository userRepository;

    // Inject the mock into the real Service class
    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserFullName_Success() {
        // 1. ARRANGE
        User mockUser = new User(1L, "Alice", "Smith");
        // Tell Mockito: When findById(1L) is called, return our mockUser
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // 2. ACT
        String result = userService.getUserFullName(1L);

        // 3. ASSERT
        assertEquals("Alice Smith", result);
        
        // 4. VERIFY (Optional but good practice)
        // Confirms the repository method was called exactly once with ID 1
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetUserFullName_UserNotFound_ThrowsException() {
        // 1. ARRANGE
        // Tell Mockito: When findById(99L) is called, return empty
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // 2. ACT & ASSERT
        // Ensure the correct exception is thrown when the user doesn't exist
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> userService.getUserFullName(99L)
        );

        assertEquals("User not found for ID: 99", exception.getMessage());
        
        verify(userRepository, times(1)).findById(99L);
    }
}