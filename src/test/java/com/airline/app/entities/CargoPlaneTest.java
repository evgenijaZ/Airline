package com.airline.app.entities;

import com.airline.app.entities.exceptions.IllegalPassengerCapacityForCargoPlaneException;
import com.airline.app.entities.exceptions.IsTooHeavyException;
import org.junit.Before;
import org.junit.Test;

public class CargoPlaneTest {
    private CargoPlane cargoPlane;

    @Before
    public void setUp() {
        cargoPlane = new CargoPlane();
    }

    @Test(expected = IllegalPassengerCapacityForCargoPlaneException.class)
    public void whenPassengerCapacityForCargoMoreThanZero_thenShouldThrowException() {
        cargoPlane.setPassengerCapacity(100);
    }

    @Test
    public void whenPassengerCapacityIsCorrect_thenShouldSetValue() {
        cargoPlane.setPassengerCapacity(0);
    }

    @Test(expected = IsTooHeavyException.class)
    public void whenCargoWeightExceedsPermissibleValues_thenShouldThrowException() {
        // when
        cargoPlane.setCarryingCapacity(400_000);
        cargoPlane.setCargoWeight(420_000);
        // then
        cargoPlane.loadCargo();
    }

    @Test(expected = IsTooHeavyException.class)
    public void whenCargoWeightExceedsPermissibleValues_thenShouldNotGoUp() {
        // when
        cargoPlane.setCarryingCapacity(400_000);
        cargoPlane.setCargoWeight(420_000);
        // then
        cargoPlane.goUp();
    }

    @Test
    public void whenCanLoadCargo_thenShouldGoUp() {
        // given
        cargoPlane.setFlying(false);
        cargoPlane.setCarryingCapacity(400_000);
        //when
        cargoPlane.setCargoWeight(300_000);
        // then
        cargoPlane.goUp();
    }

    @Test
    public void whenStateIsCorrect_thenShouldGoDown() {
        // when
        cargoPlane.setFlying(true);
        // then
        cargoPlane.goDown();
    }

}