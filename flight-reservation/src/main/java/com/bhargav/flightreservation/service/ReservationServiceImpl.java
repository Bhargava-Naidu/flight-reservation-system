package com.bhargav.flightreservation.service;

import com.bhargav.flightreservation.dtos.ReservationRequest;
import com.bhargav.flightreservation.entities.Flight;
import com.bhargav.flightreservation.entities.Passenger;
import com.bhargav.flightreservation.entities.Reservation;
import com.bhargav.flightreservation.repos.FlightRepository;
import com.bhargav.flightreservation.repos.PassengerRepository;
import com.bhargav.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Flight flight=flightRepository.findById(request.getFlightId()).get();


        Passenger passenger=new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger=passengerRepository.save(passenger);


        Reservation reservation=new Reservation();
        reservation.setPassenger(savedPassenger);
        reservation.setFlight(flight);
        Reservation savedReservation= reservationRepository.save(reservation);

        return savedReservation;
    }
}
