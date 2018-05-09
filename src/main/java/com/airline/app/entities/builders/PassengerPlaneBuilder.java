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
        Airplane airplane = super.build();
        PassengerPlane passengerPlane = new PassengerPlane();
        copyProperties(airplane, passengerPlane);
        passengerPlane.setNumberOfPassengers(numberOfPassengers);
        return passengerPlane;
    }
}
