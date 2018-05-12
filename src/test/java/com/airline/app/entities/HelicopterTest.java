package com.airline.app.entities;

import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import org.junit.Before;
import org.junit.Test;

public class HelicopterTest {
    private Helicopter helicopter;

    @Before
    public void setUp() {
        helicopter = new Helicopter();
        helicopter.setVelocity(35.3);
        helicopter.setRotorDiameter(150);
    }

    @Test
    public void whenStateIsCorrect_thenShouldGoUp() {
        // when
        helicopter.setFlying(false);
        // then
        helicopter.goUp();
    }

    @Test
    public void whenStateIsCorrect_thenShouldGoDown() {
        // when
        helicopter.setFlying(true);
        // then
        helicopter.goDown();
    }

    @Test(expected = IsAlreadyFlyingException.class)
    public void whenStateIsIncorrect_thenShouldNotGoUp() {
        // when
        helicopter.setFlying(true);
        // then
        helicopter.goUp();
    }

    @Test(expected = IsNotFlyingYetException.class)
    public void whenStateIsIncorrect_thenShouldNotGoDown() {
        // when
        helicopter.setFlying(false);
        // then
        helicopter.goDown();
    }

}