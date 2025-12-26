package com.example.bookingapp.user.dto;

import com.example.bookingapp.user.enums.Role;
import lombok.Value;

@Value
public class ReadUserDTO {
    String firstName;
    String lastName;
    String email;
    Role role;
}
