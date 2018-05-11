package com.airline.app.entities.builders;

import com.airline.app.entities.Airplane;

public class AirplaneBuilder {
    private float fuelConsumption;
    private int cruisingSpeed;
    private int carryingCapacity;
    private int flightRange;
    private String modelName;
    private int passengerCapacity;

    public AirplaneBuilder setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public AirplaneBuilder setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
        return this;
    }

    public AirplaneBuilder setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
        return this;
    }

    public AirplaneBuilder setFlightRange(int flightRange) {
        this.flightRange = flightRange;
        return this;
    }

    public AirplaneBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public AirplaneBuilder setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
        return this;
    }

    public Airplane build() {
        Airplane airplane = new Airplane();
        copyProperties(airplane);
        return airplane;
    }

    void copyProperties(Airplane plane) {
        plane.setModelName(this.modelName);
        plane.setPassengerCapacity(this.passengerCapacity);
        plane.setCarryingCapacity(this.carryingCapacity);
        plane.setCruisingSpeed(this.cruisingSpeed);
        plane.setFlightRange(this.flightRange);
        plane.setFuelConsumption(this.fuelConsumption);
    }
}
