package com.rayeka.SpringBootBrushUp.data.repository;

import com.rayeka.SpringBootBrushUp.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> getReservationsByDate(Date date);
}
