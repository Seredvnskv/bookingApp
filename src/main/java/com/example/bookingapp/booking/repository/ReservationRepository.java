package com.example.bookingapp.booking.repository;

import com.example.bookingapp.booking.Reservation;
import com.example.bookingapp.room.Room;
import com.example.bookingapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ReservationRepository  extends JpaRepository<Reservation, UUID> {
    List<Reservation> findByUserId(UUID id);
    List<Reservation> findByRoomId(UUID id);

    @Query("SELECT r FROM Reservation r WHERE r.endDate >= :start AND r.startDate <= :end")
    List<Reservation> findByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN FALSE ELSE TRUE END " + "FROM Reservation r WHERE r.room.id = :id AND r.startDate < :start AND r.endDate > :endDate")
    Boolean isRoomAvailable(@Param("id") UUID id, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
