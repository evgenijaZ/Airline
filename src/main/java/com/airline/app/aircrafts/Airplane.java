package com.airline.app.aircrafts;

/**
 * Class Airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class Airplane extends Aircraft {
    /**
     * The fuel consumption of the airplane in liters per hour
     */
    private double fuelConsumption_lph;
    /**
     * Cruising speed of the airplane in kilometre per hour
     */
    private int cruisingSpeed_kmph;

    /**
     * Constructor for class Airplane
     *
     * @param modelName           model name
     * @param capacity            aircraft capacity
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     * @param fuelConsumption_lph fuel consumption
     * @param cruisingSpeed_kmph  cruising speed
     */
    public Airplane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km);
        this.fuelConsumption_lph = fuelConsumption_lph;
        this.cruisingSpeed_kmph = cruisingSpeed_kmph;
    }

    /**
     * Inherited from the Aircraft method of takeoff
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
     * Inherited from the Aircraft method of landing
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

    /**
     * Return fuel consumption passed to the constructor or setter
     *
     * @return fuel consumption
     */
    public double getFuelConsumption_lph() {
        return fuelConsumption_lph;
    }

    /**
     * Set fuel consumption
     *
     * @param fuelConsumption_lph new value of fuel consumption
     */
    public void setFuelConsumption_lph(double fuelConsumption_lph) {
        this.fuelConsumption_lph = fuelConsumption_lph;
    }

    /**
     * Return cruising speed passes to the constructor
     *
     * @return cruising speed
     */
    public int getCruisingSpeed_kmph() {
        return cruisingSpeed_kmph;
    }

    /**
     * Represents the airplane as string
     *
     * @return airplane as string
     */
    @Override
    public String toString() {
        return (modelName + "\n\t" +
                "capacity: " + capacity + ";\n\t" +
                "carrying capacity: " + carryingCapacity_kg + "kg;\n\t" +
                "flight range: " + flightRange_km + "km;\n\t" +
                "fuel consumption: " + fuelConsumption_lph + "l/h;\n\t" +
                "cruising speed: " + cruisingSpeed_kmph + "km/h; \n");
    }
}
