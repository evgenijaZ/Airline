package com.airline.app;

/**
 * @author Yevheniia Zubrych on 03.02.2018.
 */
public abstract class Aircraft {
    /**
     * the model name of the aircraft,
     * it is defined in the constructor
     */
    private String modelName;
    /**
     * the passenger capacity of the aircraft,
     * it is defined in the constructor
     */
    private int capacity;
    /**
     * maximum carrying capacity of the aircraft in kilograms,
     * it is defined in the constructor
     */
    private int carryingCapacity_kg;
    /**
     * maximum flight range of the aircraft in kilometers,
     * it is defined in the constructor
     */
    private int flightRange_km;
    /**
     * Is there an airplane in flight,
     * default value is false
     */
    private boolean isFlying;

    public Aircraft(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km) {
        this.modelName = modelName;
        this.capacity = capacity;
        this.carryingCapacity_kg = carryingCapacity_kg;
        this.flightRange_km = flightRange_km;
        this.isFlying = false;
    }

    /**
     * abstract method of takeoff of an aircraft
     */
    public abstract void goUp();

    /**
     * abstract method of landing an aircraft
     */
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
