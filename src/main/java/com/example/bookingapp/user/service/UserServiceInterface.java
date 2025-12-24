package com.example.bookingapp.user.service;

import com.example.bookingapp.user.User;
import com.example.bookingapp.user.enums.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {
    List<User> getUsers();
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);

    void saveAll(List<User> users);
    void deleteAll();
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
}
