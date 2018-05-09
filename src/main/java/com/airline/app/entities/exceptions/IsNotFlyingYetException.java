package com.airline.app.entities.exceptions;

public class IsNotFlyingYetException extends IllegalStateException {
    public IsNotFlyingYetException(String aircraftType, String modelName) {
        super("The " + aircraftType + " " + modelName + " is not in flight yet.");
    }
}
