package com.exemple.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;



import com.exemple.model.Reservation;

public interface ReservationService {


    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    void updateReservation(Reservation reservation);
    void deleteReservationById(Long id);
    Reservation saveReservation(Reservation reservation);
    Page<Reservation> getReservationsSortedByDate(String sortByDate, Pageable pageable);

}
