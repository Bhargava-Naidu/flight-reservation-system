package com.bhargav.flightreservation.controller;


import com.bhargav.flightreservation.dtos.ReservationUpdateRequest;
import com.bhargav.flightreservation.entities.Reservation;
import com.bhargav.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationUpdateRequest reservationUpdateRequest;

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("reservations/{id}")
     public Reservation findReservation(@PathVariable("id") Long id){
        Reservation reservation=reservationRepository.findById(id).get();
        return reservation;
        }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.isCheckedIn());
        Reservation updatedReservation = reservationRepository.save(reservation);
        return updatedReservation;
    }

//        @RequestMapping("reservations")
//        public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
//        Reservation reservation=reservationRepository.findById(request.getId()).get();
//        reservation.setNumberOfBags(request.getNumberOfBags());
//        reservation.setCheckedIn(request.isCheckedIn());
//        Reservation updatedReservation=reservationRepository.save(reservation);
//        return updatedReservation;
    }

