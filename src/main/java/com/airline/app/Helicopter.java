package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Helicopter extends Aircraft {
    /**
     * the main rotor diameter in meters
     */
    double rotorDiameter_m;

    Helicopter(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double rotorDiameter_m) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.rotorDiameter_m = rotorDiameter_m;
    }

    /**
     * abstract method of takeoff of an aircraft
     */
    @Override
    public void goUp() {

    }

    /**
     * abstract method of landing an aircraft
     */
    @Override
    public void goDown() {

    }
}
