package com.airline.app.entities.builders;

import com.airline.app.entities.PassengerPlane;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class PassengerPlaneBuilderTest {

    @Autowired
    private PassengerPlaneBuilder passengerPlaneBuilder;

    @Test
    public void whetSetNumberOfPassengers_thenNumberOfPassengersShouldBeSet() {
        //given
        passengerPlaneBuilder.setNumberOfPassengers(50);

        //when
        PassengerPlane passengerPlane = passengerPlaneBuilder.build();

        //then
        assertEquals(50, passengerPlane.getNumberOfPassengers());
    }


    @TestConfiguration
    static class PassengerPlaneBuilderTestContextConfiguration {
        @Bean
        public PassengerPlaneBuilder passengerPlaneBuilder() {
            return new PassengerPlaneBuilder();
        }
    }

}