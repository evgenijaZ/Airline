package com.airline.app.aircrafts;

/**
 * Class CargoPlane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class CargoPlane extends Airplane {
    /**
     * The cargo weight in kilograms
     */
    private int cargoWeight_kg;

    /**
     * Constructor for class CargoPlane, capacity is always 0, cargo is 0 here
     *
     * @param modelName           model name
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     * @param fuelConsumption_lph fuel consumption
     * @param cruisingSpeed_kmph  cruising speed
     */
    public CargoPlane(String modelName, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = 0;
    }

    /**
     * Constructor for class CargoPlane with cargo weight, capacity is always 0
     *
     * @param modelName           model name
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     * @param fuelConsumption_lph fuel consumption
     * @param cruisingSpeed_kmph  cruising speed
     * @param cargoWeight_kg      cargo weight
     */
    public CargoPlane(String modelName, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph, int cargoWeight_kg) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = cargoWeight_kg;
    }

    /**
     * Inherited from the Airplane method of takeoff
     */
    @Override
    public void goUp() {
        if (!loadCargo()) {
            System.out.println("Takeoff of " + modelName + " is impossible");
            return;
        }
        super.goUp();
    }

    /**
     * Inherited from the Airplane method of landing
     */
    @Override
    public void goDown(){
        super.goDown();
        unloadCargo();
    }

    /**
     * Load a cargo on the plane
     *
     * @return true if whole cargo is on the board, false if something went wrong
     */
    private boolean loadCargo() {
        if (cargoWeight_kg > carryingCapacity_kg) {
            System.out.println("The cargo is too heavy for " + this.modelName + ". " + (cargoWeight_kg - carryingCapacity_kg) + " extra pounds");
            return false;
        } else
            System.out.println("Whole cargo (" + cargoWeight_kg + ") is already on the board of " + this.modelName);
        return true;
    }

    /**
     * Unload cargo from the plane
     */
    private void unloadCargo() {
        System.out.println("Whole cargo is unloaded");
    }

    /**
     * Represents the cargo plane as string
     *
     * @return plane as string
     */
    @Override
    public String toString() {
        return "The cargo plane " + super.toString() +
                "\tcargo weight: " + cargoWeight_kg + "kg;\n";
    }
}
