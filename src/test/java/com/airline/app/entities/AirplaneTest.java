package com.airline.app.entities;

import com.airline.app.entities.builders.PassengerPlaneBuilder;
import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import org.junit.Test;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */
public class AirplaneTest {
    private PassengerPlaneBuilder passengerPlaneBuilder = new PassengerPlaneBuilder();

    /**
     * Create airplane with negative arguments
     *
     * @throws IllegalArgumentException if one or more arguments are negative
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithNegativeArguments() throws Exception {
        Airplane airplane = ((PassengerPlaneBuilder) passengerPlaneBuilder
                .setModelName("Boeing 737-300")
                .setPassengerCapacity(-128)
                .setCarryingCapacity(69_400)
                .setFlightRange(6230)
                .setFuelConsumption(2400)
                .setCruisingSpeed(790))
                .setNumberOfPassengers(100)
                .build();
    }

    /**
     * Create airplane, invoke goDown when airplane isn`t flying
     *
     * @throws IsNotFlyingYetException if airplane isn`t flying
     */
    @Test(expected = IsNotFlyingYetException.class)
    public void invokeGoDownWhenNotFlying() {
        Airplane airplane = ((PassengerPlaneBuilder) passengerPlaneBuilder
                .setModelName("Boeing 737-300")
                .setPassengerCapacity(128)
                .setCarryingCapacity(69_400)
                .setFlightRange(6230)
                .setFuelConsumption(2400)
                .setCruisingSpeed(790))
                .setNumberOfPassengers(100)
                .build();
        airplane.goDown();
    }

    /**
     * Create airplane, invoke goUp when airplane is flying
     *
     * @throws IsAlreadyFlyingException if airplane is flying
     */
    @Test(expected = IsAlreadyFlyingException.class)
    public void invokeGoUpWhenIsFlying() {
        Airplane airplane = ((PassengerPlaneBuilder) passengerPlaneBuilder
                .setModelName("Boeing 737-300")
                .setPassengerCapacity(128)
                .setCarryingCapacity(69_400)
                .setFlightRange(6230)
                .setFuelConsumption(2400)
                .setCruisingSpeed(790))
                .setNumberOfPassengers(100)
                .build();
        airplane.goUp();
        airplane.goUp();
    }

}