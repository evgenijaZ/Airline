package com.airline.app.entities.exceptions;

public class IsAlreadyFlyingException extends IllegalStateException {
    public IsAlreadyFlyingException(String aircraftType, String modelName) {
        super("The " + aircraftType + " " + modelName + " is already flying.");
    }
}
