package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airplane extends Aircraft {
    /**
     * the fuel consumption of the airplane in liters per hour
     */
    private double fuelConsumption_lph;

    public Airplane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.fuelConsumption_lph = fuelConsumption_lph;
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

    public double getFuelConsumption_lph() {
        return fuelConsumption_lph;
    }

    public void setFuelConsumption_lph(double fuelConsumption_lph) {
        this.fuelConsumption_lph = fuelConsumption_lph;
    }
}
