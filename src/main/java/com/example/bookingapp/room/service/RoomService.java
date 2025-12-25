package com.example.bookingapp.room.service;

import com.example.bookingapp.room.Room;
import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import com.example.bookingapp.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService implements RoomServiceInterface {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(UUID id) {
        return roomRepository.findById(id);
    }

    @Override
    public Optional<Room> findByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public List<Room> findByLocation(Location location) {
        return roomRepository.findByLocation(location);
    }

    @Override
    public List<Room> findByType(RoomType type) {
        return roomRepository.findByType(type);
    }

    @Override
    public List<Room> findByCapacity(Integer capacity) {
        return roomRepository.findByCapacity(capacity);
    }

    @Override
    public void saveAll(List<Room> rooms) {
        roomRepository.saveAll(rooms);
    }

    @Override
    public void deleteAll() {
        roomRepository.deleteAll();
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }
}
