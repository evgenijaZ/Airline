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
    private int cruisingSpeed_kmph;

    public Airplane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.fuelConsumption_lph = fuelConsumption_lph;
        this.cruisingSpeed_kmph = cruisingSpeed_kmph;
    }

    /**
     * inherited from the Aircraft method of takeoff
     */
    @Override
    public void goUp() {
        if (this.isFlying) {
            System.out.println("The airplane " + modelName + " is already flying.");
            return;
        }
        System.out.println("The airplane " + modelName + " is leaving on a runway, accelerating, taking off.");
        isFlying = true;
        System.out.println("The airplane " + modelName + " has gained cruising speed " + this.cruisingSpeed_kmph + "km/h and flies.");
    }

    /**
     * inherited from the Aircraft method of landing
     */
    @Override
    public void goDown() {
        if (!this.isFlying) {
            System.out.println("The airplane " + modelName + " is not in flight yet.");
            return;
        }
        System.out.println("The airplane " + modelName + " is going down and landing on the runway.");
        isFlying = false;
        System.out.println("The airplane " + modelName + " has landed.");
    }

    public double getFuelConsumption_lph() {
        return fuelConsumption_lph;
    }

    public void setFuelConsumption_lph(double fuelConsumption_lph) {
        this.fuelConsumption_lph = fuelConsumption_lph;
    }

    public int getCruisingSpeed_kmph() {
        return cruisingSpeed_kmph;
    }

    public void setCruisingSpeed_kmph(int cruisingSpeed_kmph) {
        this.cruisingSpeed_kmph = cruisingSpeed_kmph;
    }

    @Override
    public String toString() {
        return (modelName + "\n\t" +
                "capacity: " + capacity + ";\n\t" +
                "carrying capacity: " + carryingCapacity_kg +"kg;\n\t"+
                "flight range: "+ flightRange_km+"km;\n\t" +
                "fuel consumption: " + fuelConsumption_lph+"l/h;\n\t" +
                "cruising speed: " +cruisingSpeed_kmph+"km/h; \n");
    }
}
