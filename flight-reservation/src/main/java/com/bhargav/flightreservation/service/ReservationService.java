package com.bhargav.flightreservation.service;

import com.bhargav.flightreservation.dtos.ReservationRequest;
import com.bhargav.flightreservation.entities.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
 Reservation bookFlight(ReservationRequest request);
}
