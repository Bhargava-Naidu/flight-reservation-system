package com.example.flightcheckin.integration;

import com.example.flightcheckin.integration.dto.Reservation;
import com.example.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ReservationRestClientImpl implements ReservationRestClient{
    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate=new RestTemplate();
        Reservation reservation=restTemplate.getForObject("http://localhost:8080/reservations/"+id,Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate=new RestTemplate();
        String url = "http://localhost:8080/reservations";
        restTemplate.put(url,request, Reservation.class);
        Reservation updatedReservation = restTemplate.getForObject(url + "/" + request.getId(), Reservation.class);
        return updatedReservation;
    }
}
