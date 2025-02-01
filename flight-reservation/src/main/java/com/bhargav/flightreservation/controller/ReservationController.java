package com.bhargav.flightreservation.controller;

import com.bhargav.flightreservation.dtos.ReservationRequest;
import com.bhargav.flightreservation.entities.Flight;
import com.bhargav.flightreservation.entities.Reservation;
import com.bhargav.flightreservation.repos.FlightRepository;
import com.bhargav.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;


    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap){
        Flight flight=flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight",flight);
        return "completereservation";
    }

    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest request, ModelMap modelMap){
        Reservation reservation=reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation Created Succesfully and reservation id is "+reservation.getId());
        return "reservationConfirmation";
    }

}
