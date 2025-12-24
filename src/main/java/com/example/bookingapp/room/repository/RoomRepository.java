package com.example.bookingapp.room.repository;

import com.example.bookingapp.room.Room;
import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByName(String name);
    List<Room> findByLocation(Location location);
    List<Room> findByType(RoomType type);
    List<Room> findByCapacity(Integer capacity);
}
