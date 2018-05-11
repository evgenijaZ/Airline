package com.airline.app.entities.builders;

import com.airline.app.entities.Airplane;
import com.airline.app.entities.PassengerPlane;

public class PassengerPlaneBuilder extends AirplaneBuilder {
    private int numberOfPassengers;

    public PassengerPlaneBuilder setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        return this;
    }

    @Override
    public PassengerPlane build() {
        PassengerPlane passengerPlane = new PassengerPlane();
        copyProperties( passengerPlane);
        return passengerPlane;
    }

    void copyProperties(PassengerPlane plane) {
        super.copyProperties(plane);
        plane.setNumberOfPassengers(this.numberOfPassengers);
    }
}
