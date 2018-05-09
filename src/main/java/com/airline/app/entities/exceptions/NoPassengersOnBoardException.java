package com.airline.app.entities.exceptions;

public class NoPassengersOnBoardException extends IllegalStateException {
    public NoPassengersOnBoardException(int passengerCapacity, String modelName) {
        super("There are no passengers on the board of " + modelName + " (passengerCapacity is " + passengerCapacity + " seats).");
    }
}
