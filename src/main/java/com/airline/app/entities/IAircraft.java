package com.airline.app.entities;

/**
 * Aircraft interface
 */
public interface IAircraft {
    /**
     * Method for flying
     */
    void goUp();

    /**
     * Method for landing
     */
    void goDown();

    /**
     * Aircraft passenger capacity
     * @return passenger capacity
     */
    int getPassengerCapacity();

    /**
     * Aircraft carrying capacity
     * @return carrying capacity in kg
     */
    int getCarryingCapacity();

    /**
     * Aircraft flight range
     * @return flight range in km
     */
    int getFlightRange();

    /**
     * Aircraft fuel consumption
     * @return fuel consumption in liters per hour
     */
    float getFuelConsumption();
}
