package com.airline.app.aircrafts;

/**
 * passenger version of the airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class PassengerPlane extends Airplane {
    /**
     * number of passengers on the plane
     */
    private int numberOfPassengers;

    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        numberOfPassengers = 0;
    }

    /*
    * the constructor with number of passengers
    */
    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph, int numberOfPassengers) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * inherited from the Airplane method of takeoff
     */
    @Override
    public void goUp() {
        if (!seatPassengers()) {
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
        freeSeats();
    }

    /**
     * to seat the passengers of the plane by places
     *
     * @return true if all passengers are on the board, false if something went wrong
     */
    private boolean seatPassengers() {
        if (numberOfPassengers > capacity) {
            System.out.println("There are not enough places on board of" + this.modelName + " for " + (numberOfPassengers - capacity) + " passengers (capacity is " + this.capacity + " seats).");
            return false;
        } else if (numberOfPassengers == 0) {
            System.out.println("There are no passengers on the board of " + this.modelName + " (capacity is " + this.capacity + " seats).");
        } else
            System.out.println("All " + numberOfPassengers + " passengers are already on the board of " + this.modelName + " (capacity is " + this.capacity + " seats).");
        return true;
    }

    /**
     * to release passenger seats
     */
    private void freeSeats() {
        System.out.println("All passengers left the the board of " + this.modelName);
    }

    @Override
    public String toString() {
        return "The passenger plane " + super.toString() +
                "\tnumber of passengers: " + numberOfPassengers + ";\n";
    }
}
