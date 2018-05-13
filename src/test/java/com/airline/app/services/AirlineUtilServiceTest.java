package com.airline.app.services;

import com.airline.app.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AirlineUtilServiceTest.AirlineUtilServiceTestContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("AirlineUtilService-test")
public class AirlineUtilServiceTest {
    @Autowired
    AirlineUtilService airlineUtilService;

    @Autowired
    @Qualifier("airline")
    Airline airline;

    @Autowired
    @Qualifier("passengerPlane")
    PassengerPlane passengerPlane;

    @Autowired
    @Qualifier("cargoPlane")
    CargoPlane cargoPlane;

    @Autowired
    @Qualifier("airship")
    Airship airship;

    @Autowired
    @Qualifier("airplane")
    Airplane airplane;

    @Autowired
    @Qualifier("helicopter")
    Helicopter helicopter;

    @Before
    public void setUp() {
        when(airline.getAircraftList()).thenCallRealMethod();
        airline.setAircraftList(new ArrayList<>());
    }

    @Test
    public void whenPassAirline_thenReturnTotalPassengerCapacity() {
        //given
        int initialCapacity = airlineUtilService.getTotalPassengerCapacity(airline);
        when(airplane.getPassengerCapacity()).thenReturn(200);
        when(airship.getPassengerCapacity()).thenReturn(390);
        when(helicopter.getPassengerCapacity()).thenReturn(345);

        airline.addAircraft(airplane);
        airline.addAircraft(airship);
        airline.addAircraft(helicopter);

        //when
        int finalCapacity = airlineUtilService.getTotalPassengerCapacity(airline);

        //then
        assertEquals(initialCapacity + 200 + 390 + 345, finalCapacity);
    }


    @Test
    public void whenPassAirline_thenReturnTotalCarryingCapacity() {
        //given
        int initialCapacity = airlineUtilService.getTotalCarryingCapacity(airline);
        when(airplane.getCarryingCapacity()).thenReturn(2000);
        when(airship.getCarryingCapacity()).thenReturn(3000);
        when(helicopter.getCarryingCapacity()).thenReturn(4000);

        airline.addAircraft(airplane);
        airline.addAircraft(airship);
        airline.addAircraft(helicopter);

        //when
        int finalCapacity = airlineUtilService.getTotalCarryingCapacity(airline);

        //then
        assertEquals(initialCapacity + 2000 + 3000 + 4000, finalCapacity);
    }


    @Test
    public void whenPassAirline_thenReturnSortedByFlightRangeListOfAircraft() {
        //given
        when(cargoPlane.getFlightRange()).thenReturn(5000);
        when(airship.getFlightRange()).thenReturn(6000);
        when(helicopter.getFlightRange()).thenReturn(5000);


        airline.addAircraft(cargoPlane);
        airline.addAircraft(airship);
        airline.addAircraft(helicopter);

        //when
        List<IAircraft> aircraftList = airlineUtilService.getSortedByFlightRangeAircraftList(airline);

        boolean sorted = true;
        for (int i = 1; i < aircraftList.size(); i++) {
            sorted = sorted && aircraftList.get(i - 1).getFlightRange() <= aircraftList.get(i).getFlightRange();
        }

        //then
        assertTrue( sorted);
    }

    @Test
    public void whenPassAirline_thenReturnFilteredFyFuelConsumptionList() {
        //given
        when(passengerPlane.getFuelConsumption()).thenReturn(2800f);
        when(airship.getFuelConsumption()).thenReturn(3400f);
        when(cargoPlane.getFuelConsumption()).thenReturn(3300f);


        airline.addAircraft(passengerPlane);
        airline.addAircraft(airship);
        airline.addAircraft(cargoPlane);

        //when
        float from = 3000, to = 4000;
        List<IAircraft> aircraftList = airlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, from, to);

        boolean filtered = true;
        for (IAircraft aircraft : aircraftList) {
            float fuelConsumption = aircraft.getFuelConsumption();
            filtered = filtered && from <= fuelConsumption && fuelConsumption <= to;
        }

        //then
        assertTrue( filtered);
    }


    @Test
    public void whenPassAirline_thenReturnFilteredFyPassengerCapacityAndFlightRangeList() {
        //given
        when(airplane.getPassengerCapacity()).thenReturn(200);
        when(airship.getPassengerCapacity()).thenReturn(390);
        when(helicopter.getPassengerCapacity()).thenReturn(345);

        when(airplane.getFlightRange()).thenReturn(5000);
        when(airship.getFlightRange()).thenReturn(6000);
        when(helicopter.getFlightRange()).thenReturn(5000);


        airline.addAircraft(airplane);
        airline.addAircraft(airship);
        airline.addAircraft(cargoPlane);

        //when
        int passengerCapacity = 200, flightRange = 5000;
        List<IAircraft> aircraftList = airlineUtilService
                .getFilteredByPassengerCapacityAndFlightRangeAircraftList(airline, passengerCapacity, flightRange);

        boolean filtered = true;
        for (IAircraft aircraft : aircraftList) {
            int capacity = aircraft.getPassengerCapacity();
            int range = aircraft.getFlightRange();
            filtered = filtered && passengerCapacity == capacity && range == flightRange;
        }

        //then
        assertTrue( filtered);
    }


    @Profile("AirlineUtilService-test")
    @Configuration
    public static class AirlineUtilServiceTestContextConfiguration {
        @Bean
        AirlineUtilService airlineUtilService(){
            return new AirlineUtilService();
        }

        @Bean("airline")
        public Airline airline() {
            return Mockito.spy(Airline.class);
        }

        @Bean("airplane")
        public Airplane airplane() {
            return Mockito.mock(Airplane.class);
        }

        @Bean("helicopter")
        public Helicopter helicopter() {
            return Mockito.mock(Helicopter.class);
        }

        @Bean("airship")
        public Airship airship() {
            return Mockito.mock(Airship.class);
        }

        @Bean("passengerPlane")
        public PassengerPlane passengerPlane() {
            return Mockito.mock(PassengerPlane.class);
        }

        @Bean("cargoPlane")
        public CargoPlane cargoPlane() {
            return Mockito.mock(CargoPlane.class);
        }
    }
}