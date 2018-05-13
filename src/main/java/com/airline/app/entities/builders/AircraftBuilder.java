package com.airline.app.entities.builders;

import com.airline.app.entities.Aircraft;

public abstract class AircraftBuilder {
    private float fuelConsumption;
    private int carryingCapacity;
    private int flightRange;
    private String modelName;
    private int passengerCapacity;

    public AircraftBuilder setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public AircraftBuilder setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
        return this;
    }

    public AircraftBuilder setFlightRange(int flightRange) {
        this.flightRange = flightRange;
        return this;
    }

    public AircraftBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public AircraftBuilder setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        return this;
    }

    abstract Aircraft build();

    void copyProperties(Aircraft plane) {
        plane.setModelName(this.modelName);
        plane.setPassengerCapacity(this.passengerCapacity);
        plane.setCarryingCapacity(this.carryingCapacity);
        plane.setFlightRange(this.flightRange);
        plane.setFuelConsumption(this.fuelConsumption);
    }
}
