package com.example.bookingapp.room.dto;

import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class UpdateRoomDTO {
    String name;

    @Min(value = 4, message = "Minimal number of people in room is 4")
    Integer capacity;

    Location location;

    RoomType type;
}
