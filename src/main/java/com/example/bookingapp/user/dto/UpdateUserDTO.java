package com.example.bookingapp.user.dto;

import jakarta.validation.constraints.Email;
import lombok.Value;

@Value
public class UpdateUserDTO {
    String firstName;
    String lastName;

    @Email(message = "Email requires to be in correct format")
    String email;
}
