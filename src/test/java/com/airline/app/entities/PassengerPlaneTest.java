package com.airline.app.entities;

import com.airline.app.entities.exceptions.NotEnoughPlacesException;
import org.junit.Before;
import org.junit.Test;

public class PassengerPlaneTest {
    private PassengerPlane passengerPlane;

    @Before
    public void setUp() {
        passengerPlane = new PassengerPlane();
    }

    @Test(expected = NotEnoughPlacesException.class)
    public void whenNumberOfPassengersMoreThanCapacity_thenThrowException() {
        // given
        passengerPlane.setPassengerCapacity(300);
        // when
        passengerPlane.setNumberOfPassengers(350);
        // then
        passengerPlane.goUp();
    }

    @Test
    public void whenNumberOfPassengersIsCorrect_thenGoUp() {
        // given
        passengerPlane.setPassengerCapacity(300);
        // when
        passengerPlane.setNumberOfPassengers(200);
        // then
        passengerPlane.goUp();
    }


    @Test
    public void whenStateIsCorrect_thenShouldGoDown() {
        // when
        passengerPlane.setFlying(true);
        // then
        passengerPlane.goDown();
    }

}