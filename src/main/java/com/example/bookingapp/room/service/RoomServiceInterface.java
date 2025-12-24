package com.example.bookingapp.room.service;

import com.example.bookingapp.room.Room;
import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomServiceInterface {
    List<Room> getRooms();
    Optional<Room> findById(UUID id);
    Optional<Room> findByName(String name);
    List<Room> findByLocation(Location location);
    List<Room> findByType(RoomType type);
    List<Room> findByCapacity(Integer capacity);

    void saveAll(List<Room> rooms);
    void deleteAll();
    Room addRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoom(Room room);
}
