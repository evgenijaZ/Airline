package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Helicopter extends Aircraft {
    /**
     * the main rotor diameter in meters
     */
    private double rotorDiameter_m;
    /**
     * speed of the helicopter blades in meters per second
     */
    private double velocity_mps;

    Helicopter(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double rotorDiameter_m) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.rotorDiameter_m = rotorDiameter_m;
        this.velocity_mps = 0;
    }

    /**
     * inherited from the Aircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (isFlying) {
            System.out.println("The helicopter " + modelName + " is already flying.");
            return;
        }
        rotate();
        isFlying = true;
        System.out.println("The helicopter " + modelName + " goes up.");
    }

    /**
     * inherited from the Aircraft method of landing
     */
    @Override
    public void goDown() {
        if (!isFlying) {
            System.out.println("The helicopter " + modelName + " is not in flight yet.");
            return;
        }
        this.velocity_mps = 0;
        isFlying = false;
        System.out.println("The helicopter " + modelName + " goes down.");
    }

    /**
     * rotate the blades of a helicopter
     */
    void rotate() {
        velocity_mps = (rotorDiameter_m / 2) * (3.14 * 190 / 30);
        System.out.println("The helicopter rotates. Speed of the helicopter blades is " + this.velocity_mps + " mps");
    }

    public double getRotorDiameter_m() {
        return rotorDiameter_m;
    }

    public void setRotorDiameter_m(double rotorDiameter_m) {
        this.rotorDiameter_m = rotorDiameter_m;
    }

    public double getVelocity_mps() {
        return velocity_mps;
    }

    void setVelocity_mps(double velocity_mps) {
        this.velocity_mps = velocity_mps;
    }
}
