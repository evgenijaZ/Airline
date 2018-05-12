package com.airline.app.entities.builders;

import com.airline.app.entities.Airship;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class AirshipBuilderTest {

    @Autowired
    private AirshipBuilder airshipBuilder;

    @Test
    public void whetSetFuelConsumption_thenConsumptionShouldBeSet() {
        //given
        airshipBuilder.setFuelConsumption(345);

        //when
        Airship airship = airshipBuilder.build();

        //then
        assertEquals(345, airship.getFuelConsumption(), 0);
    }

    @Test
    public void whetSetFlightRange_thenRangeShouldBeSet() {
        //given
        airshipBuilder.setFlightRange(4000);

        //when
        Airship airship = airshipBuilder.build();

        //then
        assertEquals(4000, airship.getFlightRange());
    }

    @Test
    public void whetSetPassengerCapacity_thenCapacityShouldBeSet() {
        //given
        airshipBuilder.setPassengerCapacity(100);

        //when
        Airship airship = airshipBuilder.build();

        //then
        assertEquals(100, airship.getPassengerCapacity());
    }

    @Test
    public void whetSetCarryingCapacity_thenCapacityShouldBeSet() {
        //given
        airshipBuilder.setCarryingCapacity(4000);

        //when
        Airship airship = airshipBuilder.build();

        //then
        assertEquals(4000, airship.getCarryingCapacity());
    }

    @Test
    public void whetSetModelName_thenModelShouldBeSet() {
        //given
        airshipBuilder.setModelName("Zeppelin");

        //when
        Airship airship = airshipBuilder.build();

        //then
        assertEquals("Zeppelin", airship.getModelName());
    }

    @TestConfiguration
    static class AirshipBuilderTestContextConfiguration {
        @Bean
        public AirshipBuilder airshipBuilder() {
            return new AirshipBuilder();
        }
    }

}