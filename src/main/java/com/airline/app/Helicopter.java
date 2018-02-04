package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Helicopter extends Aircraft {
    /**
     * the main rotor diameter in meters
     */
    double rotorDiameter_m;
    /**
     * speed of the helicopter blades in meters per second
     */
    double velocity_mps;

    Helicopter(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double rotorDiameter_m) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.rotorDiameter_m = rotorDiameter_m;
        this.velocity_mps = 0;
    }

    /**
     * abstract method of takeoff of an aircraft
     */
    @Override
    public void goUp() {
        rotate();
        isFlying = true;
        System.out.println("The helicopter " + modelName + " goes up.");
    }

    /**
     * abstract method of landing an aircraft
     */
    @Override
    public void goDown() {
        this.velocity_mps = 0;
        isFlying = false;
        System.out.println("The helicopter " + modelName + " goes down.");
    }

    /**
     * rotate the blades of a helicopter
     */
    public void rotate() {
        velocity_mps = (rotorDiameter_m / 2) * (3.14 * 190 / 30);
        System.out.println("The helicopter rotates. Speed of the helicopter blades is " + this.velocity_mps + " mps");
    }

    public double getRotorDiameter_m() {
        return rotorDiameter_m;
    }

    public void setRotorDiameter_m(double rotorDiameter_m) {
        this.rotorDiameter_m = rotorDiameter_m;
    }
}
