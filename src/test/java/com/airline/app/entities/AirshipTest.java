package com.airline.app.entities;

import com.airline.app.entities.exceptions.IsAlreadyFlyingException;
import com.airline.app.entities.exceptions.IsNotFlyingYetException;
import org.junit.Before;
import org.junit.Test;

public class AirshipTest {
    private Airship airship;

    @Before
    public void setUp() {
        airship = new Airship();
    }

    @Test
    public void whenStateIsCorrect_thenShouldGoUp() {
        // when
        airship.setFlying(false);
        // then
        airship.goUp();
    }
    @Test
    public void whenStateIsCorrect_thenShouldGoDown() {
        // when
        airship.setFlying(true);
        // then
        airship.goDown();
    }

    @Test(expected = IsAlreadyFlyingException.class)
    public void whenStateIsIncorrect_thenShouldNotGoUp() {
        // when
        airship.setFlying(true);
        // then
        airship.goUp();
    }

    @Test(expected = IsNotFlyingYetException.class)
    public void whenStateIsIncorrect_thenShouldNotGoDown() {
        // when
        airship.setFlying(false);
        // then
        airship.goDown();
    }
}