package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airplane extends Aircraft {
    /**
     * the fuel consumption of the airplane in liters per hour
     */
    private double fuelConsumption_lph;
    /**
     * cruising speed of the airplane in kilometre per hour
     */
    private double cruisingSpeed_kmph;

    public Airplane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.fuelConsumption_lph = fuelConsumption_lph;
        this.cruisingSpeed_kmph = cruisingSpeed_kmph;
    }

    /**
     * abstract method of takeoff of an aircraft
     */
    @Override
    public void goUp() {
        if (this.isFlying) {
            System.out.println("The airplane " + modelName + " is already flying.");
            return;
        }
        System.out.println("The airplane " + modelName + " leaves on a runway, accelerates, takes off.");
        isFlying = true;
        System.out.println("The airplane " + modelName + " gained cruising speed " + this.cruisingSpeed_kmph + "km/h and goes up.");
    }

    /**
     * abstract method of landing an aircraft
     */
    @Override
    public void goDown() {
        if (!this.isFlying) {
            System.out.println("The airplane " + modelName + " is not in flight yet.");
            return;
        }
        System.out.println("The airplane " + modelName + " lands on the runway.");
        isFlying = false;
        System.out.println("The airplane " + modelName + " goes down.");
    }

    public double getFuelConsumption_lph() {
        return fuelConsumption_lph;
    }

    public void setFuelConsumption_lph(double fuelConsumption_lph) {
        this.fuelConsumption_lph = fuelConsumption_lph;
    }

    public double getCruisingSpeed_kmph() {
        return cruisingSpeed_kmph;
    }

    public void setCruisingSpeed_kmph(double cruisingSpeed_kmph) {
        this.cruisingSpeed_kmph = cruisingSpeed_kmph;
    }
}
