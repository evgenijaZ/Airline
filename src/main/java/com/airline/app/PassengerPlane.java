package com.airline.app;

/**
 * passenger version of the airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class PassengerPlane extends Airplane {
    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, double cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
    }

    @Override
    public void goUp() {
        seatPassengers();
        super.goUp();
    }

    /**
     * seat the passengers of the plane by places
     */
    private void seatPassengers() {
        System.out.println("All passengers are already on the board of " + this.modelName + " (capacity is " + this.capacity + " seats).");
    }
}
