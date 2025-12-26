package com.example.bookingapp.room.controller;

import com.example.bookingapp.room.Room;
import com.example.bookingapp.room.dto.CreateRoomDTO;
import com.example.bookingapp.room.dto.ReadRoomDTO;
import com.example.bookingapp.room.dto.UpdateRoomDTO;
import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import com.example.bookingapp.room.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<ReadRoomDTO>> getRooms() {
        return new ResponseEntity<>(roomService.getRooms()
                .stream()
                .map(
                        room -> new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType())
                ).toList(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ReadRoomDTO> getGetRoomByName(@PathVariable("uuid") UUID uuid) {
        Room room = roomService.findById(uuid).orElse(null);

        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType()), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<ReadRoomDTO> getRoomByName(@PathVariable("name") String name) {
        Room room = roomService.findByName(name).orElse(null);

        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType()), HttpStatus.OK);
    }

    @GetMapping("location/{location}")
    public ResponseEntity<List<ReadRoomDTO>> getRoomByLocation(@PathVariable("location") Location location) {
        return new ResponseEntity<>(roomService.findByLocation(location)
                .stream()
                .map(
                        room -> new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType())
                ).toList(), HttpStatus.OK);
    }

    @GetMapping("type/{type}")
    public ResponseEntity<List<ReadRoomDTO>> getRoomByType(@PathVariable("type") RoomType type) {
        return new ResponseEntity<>(roomService.findByType(type)
                .stream()
                .map(
                        room -> new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType())
                ).toList(), HttpStatus.OK);
    }

    @GetMapping("/capacity/{value}")
    public ResponseEntity<List<ReadRoomDTO>> getRoomByCapacity(@PathVariable("value") Integer value) {
        return new ResponseEntity<>(roomService.findByCapacity(value)
                .stream()
                .map(
                        room -> new ReadRoomDTO(room.getName(), room.getCapacity(), room.getLocation(), room.getType())
                ).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateRoomDTO> createRoom(@Valid @RequestBody CreateRoomDTO dto) {
        Room room = Room.builder().name(dto.getName()).location(dto.getLocation()).type(dto.getType()).build();
        roomService.addRoom(room);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<UpdateRoomDTO> updateRoom(@PathVariable("uuid") UUID uuid, @Valid @RequestBody UpdateRoomDTO dto) {
        Room room = roomService.findById(uuid).orElse(null);

        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (dto.getName() != null) room.setName(dto.getName());
        if (dto.getCapacity() != null) room.setCapacity(dto.getCapacity());
        if (dto.getLocation() != null) room.setLocation(dto.getLocation());
        if (dto.getType() != null) room.setType(dto.getType());

        roomService.updateRoom(room);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<UpdateRoomDTO> deleteRoom(@PathVariable("uuid") UUID uuid) {
        Room room = roomService.findById(uuid).orElse(null);

        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roomService.deleteRoom(room);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
