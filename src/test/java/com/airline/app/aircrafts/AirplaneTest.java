package com.airline.app.aircrafts;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yevheniia Zubrych on 06.02.2018.
 */
public class AirplaneTest {
    /**
     * Create airplane with negative arguments
     * @throws IllegalArgumentException if one or more arguments are negative
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithNegativeArguments() throws Exception {
        Airplane airplane = new Airplane("Boeing 737-300", -128, 69400, 6230, 2400, 790);
    }

    /**
     * Create airplane, invoke goDown when airplane isn`t flying
     * @throws IllegalArgumentException if airplane isn`t flying
     */
    @Test(expected = IllegalArgumentException.class)
    public void invokeGoDownWhenNotFlying(){
        Airplane airplane = new Airplane("Boeing 737-300", 128, 69400, 6230, 2400, 790);
        airplane.goDown();
    }

    /**
     * Create airplane, invoke goUp when airplane is flying yet
     * @throws IllegalArgumentException if airplane is flying
     */
    @Test(expected = IllegalArgumentException.class)
    public void invokeGoUpWhenIsFlying(){
        Airplane airplane = new Airplane("Boeing 737-300", 128, 69400, 6230, 2400, 790);
        airplane.goUp();
        airplane.goUp();
    }

}