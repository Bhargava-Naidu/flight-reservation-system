package com.bhargav.flightreservation.dtos;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReservationUpdateRequest {


    //we dont need to add the entire reseravtion object as we have to modfy only three
    private long id;
    private Boolean checkedIn;
    private int numberOfBags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }
}
