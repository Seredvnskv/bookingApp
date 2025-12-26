package com.example.bookingapp.room.dto;

import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import lombok.Value;

@Value
public class ReadRoomDTO {
    String name;
    Integer capacity;
    Location location;
    RoomType type;
}
