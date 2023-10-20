package com.tech.user_service.services;

import com.tech.user_service.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
}
