package com.airline.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class AbstractAircraft
 *
 * @author Yevheniia Zubrych on 03.02.2018.
 */
@Getter
@NoArgsConstructor
public abstract class AbstractAircraft implements Aircraft {
    /**
     * The model name of the aircraftList,
     * It is defined in the constructor
     */
    @Setter
    private String modelName;
    /**
     * The passenger passengerCapacity of the aircraftList,
     * It is defined in the constructor
     */
    private int passengerCapacity;
    /**
     * Maximum carrying passengerCapacity of the aircraftList in kilograms,
     * It is defined in the constructor
     */
    private int carryingCapacity;
    /**
     * Maximum flight range of the aircraftList in kilometers,
     * It is defined in the constructor
     */
    private int flightRange;
    /**
     * The fuel consumption of the airplane in liters per hour
     */
    private float fuelConsumption;
    /**
     * Is there an airplane in flight,
     * Default value is false
     */
    @Setter
    private boolean isFlying;

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public int getFlightRange() {
        return flightRange;
    }

    @Override
    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity >= 0)
            this.passengerCapacity = passengerCapacity;
        else throw new IllegalArgumentException("Passenger capacity cannot be negative: " + passengerCapacity + "<0");
    }

    public void setCarryingCapacity(int carryingCapacity) {
        if (carryingCapacity >= 0)
            this.carryingCapacity = carryingCapacity;
        else throw new IllegalArgumentException("Carrying capacity cannot be negative: " + carryingCapacity + "<0");
    }

    public void setFlightRange(int flightRange) {
        if (flightRange >= 0)
            this.flightRange = flightRange;
        else throw new IllegalArgumentException("Flight range cannot be negative: " + flightRange + "<0");
    }

    public void setFuelConsumption(float fuelConsumption) {
        if (flightRange >= 0)
            this.fuelConsumption = fuelConsumption;
        else throw new IllegalArgumentException("Fuel consumption cannot be negative: " + fuelConsumption + "<0");
    }
}
