package com.airline.app.aircrafts;

/**
 * Class passenger plane
 * passenger version of the airplane
 *
 * @author Yevheniia Zubrych on 04.02.2018.
 */
public class PassengerPlane extends Airplane {
    /**
     * Number of passengers on the plane
     */
    private int numberOfPassengers;

    /**
     * Constructor for class PassengerPlane
     *
     * @param modelName           model name
     * @param capacity            capacity
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     * @param fuelConsumption_lph fuel consumption
     * @param cruisingSpeed_kmph  cruising speed
     */
    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        numberOfPassengers = 0;
    }

    /**
     * Constructor for class PassengerPlane with number of passengers
     *
     * @param modelName           model name
     * @param capacity            capacity
     * @param carryingCapacity_kg carrying capacity
     * @param flightRange_km      flight range
     * @param fuelConsumption_lph fuel consumption
     * @param cruisingSpeed_kmph  cruising speed
     * @param numberOfPassengers  number of passengers
     */
    public PassengerPlane(String modelName, int capacity, int carryingCapacity_kg, int flightRange_km, double fuelConsumption_lph, int cruisingSpeed_kmph, int numberOfPassengers) {
        super(modelName, capacity, carryingCapacity_kg, flightRange_km, fuelConsumption_lph, cruisingSpeed_kmph);
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Inherited from the Airplane method of takeoff
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
     * Inherited from the Airplane method of landing
     */
    @Override
    public void goDown() {
        super.goDown();
        freeSeats();
    }

    /**
     * Seat the passengers of the plane by places
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
            System.out.println("All " + numberOfPassengers + " passengers are already on the board of " + this.modelName + ".");
        return true;
    }

    /**
     * Release passenger seats
     */
    private void freeSeats() {
        System.out.println("All passengers left the the board of " + this.modelName);
    }

    /**
     * Represents the passenger plane as string
     *
     * @return plane as string
     */
    @Override
    public String toString() {
        return "The passenger plane " + super.toString() +
                "\tnumber of passengers: " + numberOfPassengers + ";\n";
    }
}
