package com.example.bookingapp.user;

import com.example.bookingapp.user.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "_user")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Firstname can't be empty")
    private String firstName;

    @NotBlank(message = "Lastname can't be empty")
    private String lastName;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email requires to be in correct format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 6, message = "Password has to be 6 characters long")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
