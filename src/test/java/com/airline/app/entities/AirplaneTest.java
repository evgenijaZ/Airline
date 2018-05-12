package com.airline.app.entities;

import com.airline.app.entities.builders.AirplaneBuilder;
import com.airline.app.entities.builders.PassengerPlaneBuilder;
import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */
public class AirplaneTest {
    private Airplane airplane;

    @Before
    public void setUp() {
        airplane = new Airplane();
        airplane.setModelName("Embraer E-190");
    }

    @Test(expected = IsNotFlyingYetException.class)
    public void whenIsNotFlying_thenCannotGoDown() {
        // given
        airplane.setFlying(false);

        // then
        airplane.goDown();
    }


    @Test(expected = IsAlreadyFlyingException.class)
    public void whenIsFlying_thenCannotGoUp() {
        // given
        airplane.setFlying(false);
        // when
        airplane.goUp();
        // then
        airplane.goUp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassengerCapacityIsNegative_thenShouldThrowException() {
        airplane.setPassengerCapacity(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFuelConsumptionIsNegative_thenShouldThrowException() {
        airplane.setFuelConsumption(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCarryingCapacityIsNegative_thenShouldThrowException() {
        airplane.setCarryingCapacity(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFlightRangeIsNegative_thenShouldThrowException() {
        airplane.setFlightRange(-1);
    }
}