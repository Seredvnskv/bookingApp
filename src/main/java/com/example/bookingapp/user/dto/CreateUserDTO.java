package com.example.bookingapp.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CreateUserDTO {
    @NotBlank(message = "Firstname can't be empty")
    String firstName;

    @NotBlank(message = "Lastname can't be empty")
    String lastName;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email requires to be in correct format")
    String email;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 6, message = "Password has to be 6 characters long")
    String password;
}
