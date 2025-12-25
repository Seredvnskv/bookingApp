package com.example.bookingapp.room;

import com.example.bookingapp.room.enums.Location;
import com.example.bookingapp.room.enums.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "_room")
@NoArgsConstructor
@AllArgsConstructor

public class Room {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Room name is required")
    @Column(unique = true)
    private String name;

    @Min(value = 4, message = "Minimal number of people in room is 4")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room location can't be null")
    private Location location;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Room type can't be null")
    private RoomType type;
}
