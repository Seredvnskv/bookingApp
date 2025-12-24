package com.example.bookingapp.booking.service;

import com.example.bookingapp.booking.Reservation;
import com.example.bookingapp.booking.repository.ReservationRepository;
import com.example.bookingapp.room.Room;
import com.example.bookingapp.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReservationService implements ReservationServiceInterface {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(UUID id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findByUser(UUID id) {
        return reservationRepository.findByUserId(id);
    }

    @Override
    public List<Reservation> findByRoom(UUID id) {
        return reservationRepository.findByRoomId(id);
    }

    @Override
    public List<Reservation> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return reservationRepository.findByDateRange(start, end);
    }

    @Override
    public Boolean isRoomAvailable(UUID id, LocalDateTime start, LocalDateTime end) {
        return reservationRepository.isRoomAvailable(id, start, end);
    }

    @Override
    public void saveAll(List<Reservation> reservations) {
        reservationRepository.saveAll(reservations);
    }

    @Override
    public void deleteAll() {
        reservationRepository.deleteAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
    }
}
