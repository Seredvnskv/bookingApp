package com.example.bookingapp.room.dto;

import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CreateRoomDTO {
    @NotBlank(message = "Name can't be empty")
    String name;

    @Min(value = 4, message = "Minimal number of people in room is 4")
    Integer capacity;

    @NotNull(message = "Room location can't be null")
    Location location;

    @NotNull(message = "Room type can't be null")
    RoomType type;
}
