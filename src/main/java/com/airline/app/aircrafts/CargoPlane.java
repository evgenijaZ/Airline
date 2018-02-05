package com.airline.app.aircrafts;

/**
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class CargoPlane extends Airplane {
    /**
     * the cargo weight in kilograms
     */
    private int cargoWeight_kg;

    public CargoPlane(String modelName, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = 0;
    }

    /*
    * the constructor with cargo weight
    */
    public CargoPlane(String modelName, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph, int cargoWeight_kg) {
        super(modelName, 0, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.cargoWeight_kg = cargoWeight_kg;
    }

    /**
     * inherited from the Airplane method of takeoff
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
     * inherited from the Airplane method of landing
     */
    @Override
    public void goDown() {
        super.goDown();
        unloadCargo();
    }

    /**
     * to load a cargo on the plane
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
     * to unload cargo from the plane
     */
    private void unloadCargo() {
        System.out.println("Whole cargo is unloaded");
    }

    @Override
    public String toString() {
        return "The cargo plane " + super.toString() +
                "\tcargo weight: " + cargoWeight_kg + "kg;\n";
    }
}
