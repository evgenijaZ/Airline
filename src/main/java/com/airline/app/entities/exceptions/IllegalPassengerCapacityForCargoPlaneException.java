package com.airline.app.entities.exceptions;

public class IllegalPassengerCapacityForCargoPlaneException extends IllegalArgumentException {
    public IllegalPassengerCapacityForCargoPlaneException(String s) {
        super(s);
    }
}
