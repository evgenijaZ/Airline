package com.airline.app.entities.exceptions;

public class IsTooHeavyException extends IllegalStateException {

    public IsTooHeavyException(String modelName, int cargoWeight, int carryingCapacity) {
        System.out.println("The cargo is too heavy for " + modelName + ". " + (cargoWeight - carryingCapacity) + " extra pounds");
    }
}
