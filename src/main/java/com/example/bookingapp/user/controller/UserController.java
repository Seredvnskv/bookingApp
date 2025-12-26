package com.example.bookingapp.user.controller;

import com.example.bookingapp.user.User;
import com.example.bookingapp.user.dto.CreateUserDTO;
import com.example.bookingapp.user.dto.ReadUserDTO;
import com.example.bookingapp.user.dto.UpdateUserDTO;
import com.example.bookingapp.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ReadUserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers()
                .stream()
                .map(user -> new ReadUserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()))
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ReadUserDTO> getUser(@PathVariable("uuid") UUID uuid) {
        User user = userService.findById(uuid).orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ReadUserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ReadUserDTO> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email).orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ReadUserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateUserDTO> saveUser(@Valid @RequestBody CreateUserDTO dto) {
        User user = User.builder().firstName(dto.getFirstName()).lastName(dto.getLastName()).email(dto.getEmail()).password(dto.getPassword()).build();

        userService.addUser(user);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<UpdateUserDTO> updateUser(@PathVariable("uuid") UUID uuid, @Valid @RequestBody UpdateUserDTO dto) {
        User user = userService.findById(uuid).orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (dto.getFirstName() != null) user.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) user.setLastName(dto.getLastName());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<UpdateUserDTO> deleteUser(@PathVariable("uuid") UUID uuid) {
        User user = userService.findById(uuid).orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
