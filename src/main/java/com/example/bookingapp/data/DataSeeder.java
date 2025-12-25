package com.example.bookingapp.data;

import com.example.bookingapp.room.Room;
import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import com.example.bookingapp.room.service.RoomService;
import com.example.bookingapp.user.User;
import com.example.bookingapp.user.enums.Role;
import com.example.bookingapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final UserService userService;
    private final RoomService roomService;

    @Autowired
    public DataSeeder(UserService userService, RoomService roomService) {
        System.out.println("[DEBUG_LOG] DataSeeder initialized");
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[DEBUG_LOG] DataSeeder running...");
        seedUsers();
        seedRooms();
        System.out.println("[DEBUG_LOG] DataSeeder finished.");
    }

    private void seedUsers() {
        if (userService.getUsers().isEmpty()) {
            User admin = User.builder()
                    .firstName("Admin")
                    .lastName("User")
                    .email("admin@example.com")
                    .password("admin123")
                    .role(Role.ADMIN)
                    .build();

            User user = User.builder()
                    .firstName("Regular")
                    .lastName("User")
                    .email("user@example.com")
                    .password("user123")
                    .role(Role.USER)
                    .build();

            userService.saveAll(List.of(admin, user));
        }
    }

    private void seedRooms() {
        if (roomService.getRooms().isEmpty()) {
            Room room1 = Room.builder()
                    .name("Conference Room A")
                    .capacity(10)
                    .location(Location.FIRST_FLOOR)
                    .type(RoomType.CONFERENCE)
                    .build();

            Room room2 = Room.builder()
                    .name("Meeting Room B")
                    .capacity(6)
                    .location(Location.GROUND_FLOOR)
                    .type(RoomType.MEETING)
                    .build();

            Room room3 = Room.builder()
                    .name("Lecture Hall C")
                    .capacity(50)
                    .location(Location.SECOND_FLOOR)
                    .type(RoomType.LECTURE)
                    .build();

            roomService.saveAll(List.of(room1, room2, room3));
        }
    }
}
