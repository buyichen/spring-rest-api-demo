package com.example.springrestfuldemo.service;

import com.example.springrestfuldemo.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User deleteUserById(Long id);
    User updateUserById(Long id, User user);
}
