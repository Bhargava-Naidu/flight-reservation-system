package com.bhargav.flightreservation.controller;

import com.bhargav.flightreservation.entities.Flight;
import com.bhargav.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {

    @Autowired
    public FlightRepository flightRepository;

    @GetMapping("/findFlights")
    public String showFindFlights(){
        return "findFlights";
    }

    @PostMapping("/findFlights")
    public String displayFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate, ModelMap modelMap){
        List<Flight>flights=flightRepository.findFlights(from,to,departureDate);
        modelMap.addAttribute("flights",flights);
        return "displayFlights";
    }





}
