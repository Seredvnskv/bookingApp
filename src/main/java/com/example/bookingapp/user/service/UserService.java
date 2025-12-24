package com.example.bookingapp.user.service;

import com.example.bookingapp.user.User;
import com.example.bookingapp.user.enums.Role;
import com.example.bookingapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
