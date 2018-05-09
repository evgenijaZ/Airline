package com.airline.app.entities.exceptions;

public class NotEnoughPlacesException extends IllegalStateException {
    public NotEnoughPlacesException(int numberOfPassengers, int passengerCapacity, String modelName) {
        super("There are not enough places on board of" + modelName
                + " for " + (numberOfPassengers - passengerCapacity)
                + " passengers (passengerCapacity is " + passengerCapacity + " seats).");

    }
}
