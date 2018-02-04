package com.airline.app;

/**
 * passenger version of the airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class PassengerPlane extends Airplane {
    private int numberOfPassengers;

    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        numberOfPassengers = 0;
    }

    public PassengerPlane(String modelName, int capacity, int numberOfPassengers, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void goUp() {
        if (!seatPassengers()) {
            System.out.println("Takeoff of " + modelName + " is impossible");
            return;
        }
        super.goUp();
    }

    /**
     * seat the passengers of the plane by places
     * @return true in case of successful execution, false if something went wrong
     */
    private boolean seatPassengers() {
        if (numberOfPassengers > capacity) {
            System.out.println("There are not enough places on board of" + this.modelName +" for " + (numberOfPassengers - capacity) + " passengers (capacity is " + this.capacity + " seats).");
            return false;
        } else if (numberOfPassengers == 0) {
            System.out.println("There are no passengers on the board of " + this.modelName + " (capacity is " + this.capacity + " seats).");
        } else
            System.out.println("All " + numberOfPassengers + " passengers are already on the board of " + this.modelName + " (capacity is " + this.capacity + " seats).");
        return true;
    }
}
