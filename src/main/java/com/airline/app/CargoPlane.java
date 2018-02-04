package com.airline.app;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class CargoPlane extends Airplane {
    /**
     * the cargo weight in kilograms
     */
    private int cargoWeight_kg;

    public CargoPlane(String modelName, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = 0;
    }

    /*
    * the constructor with cargo weight
    */
    public CargoPlane(String modelName, int carryingCapacity_kg, int cargoWeight_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = cargoWeight_kg;
    }

    /**
     * to load a cargo on the plane
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

}
