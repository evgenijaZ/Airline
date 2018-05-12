package com.airline.app.entities.builders;

import com.airline.app.entities.Helicopter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelicopterBuilderTest {

    @Autowired
    private HelicopterBuilder helicopterBuilder;

    @Test
    public void whetSetRotorDiameter_thenRotorDiameterShouldBeSet() {
        //given
        helicopterBuilder.setRotorDiameter(15);

        //when
        Helicopter helicopter = helicopterBuilder.build();

        //then
        assertEquals(15, helicopter.getRotorDiameter(), 0);
    }

    @Test
    public void whetSetVelocity_thenVelocityShouldBeSet() {
        //given
        helicopterBuilder.setVelocity(500);

        //when
        Helicopter helicopter = helicopterBuilder.build();

        //then
        assertEquals(500, helicopter.getVelocity(), 0);
    }


    @TestConfiguration
    static class HelicopterBuilderTestContextConfiguration {
        @Bean
        public HelicopterBuilder helicopterBuilder() {
            return new HelicopterBuilder();
        }
    }

}