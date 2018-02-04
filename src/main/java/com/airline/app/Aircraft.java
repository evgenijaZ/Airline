package com.airline.app;

/**
 * @author Yevheniia Zubrych on 03.02.2018.
 */
public abstract class Aircraft {
    private String modelName;
    private int capacity;
    private int carryingCapacity_kg;
    private int flightRange_km;
    private boolean isFlying;

    public Aircraft(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km) {
        this.modelName = modelName;
        this.capacity = capacity;
        this.carryingCapacity_kg = carryingCapacity_kg;
        this.flightRange_km = flightRange_km;
        this.isFlying = false;
    }

    public abstract void goUp();

    public abstract void goDown();

    public String getModelName() {
        return modelName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCarryingCapacity_kg() {
        return carryingCapacity_kg;
    }

    public int getFlightRange_km() {
        return flightRange_km;
    }

    public boolean isFlying() {
        return isFlying;
    }
}
