package com.example.bookingapp.booking.service;

import com.example.bookingapp.booking.Reservation;
import com.example.bookingapp.room.Room;
import com.example.bookingapp.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationServiceInterface {
    List<Reservation> getReservations();
    Optional<Reservation> findById(UUID id);
    List<Reservation> findByUser(UUID id);
    List<Reservation> findByRoom(UUID id);
    List<Reservation> findByDateRange(LocalDateTime start, LocalDateTime end);
    Boolean isRoomAvailable(UUID id, LocalDateTime start, LocalDateTime end);

    void saveAll(List<Reservation> reservations);
    void deleteAll();
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(UUID id);
}
