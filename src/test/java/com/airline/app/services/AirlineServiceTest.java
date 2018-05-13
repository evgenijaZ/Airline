package com.airline.app.services;

import com.airline.app.entities.Airline;
import com.airline.app.entities.Airplane;
import com.airline.app.entities.Airship;
import com.airline.app.entities.IAircraft;
import com.airline.app.repositories.AirlineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AirlineServiceTest {

    @Autowired
    AirlineService airlineService;
    @MockBean
    AirlineUtilService airlineUtilService;
    @MockBean
    AircraftService aircraftService;
    @MockBean
    AirlineRepository airlineRepository;
    @MockBean
    Airline airline;
    @MockBean
    Airship airship;
    @MockBean
    Airplane airplane;

    @Test
    public void whenValidId_thenAirlineShouldBeFound() {
        long id = 100;
        when(airline.getId()).thenReturn(id);
        when(airlineRepository.getOne(airline.getId()))
                .thenReturn(airline);
        //when
        Airline found = airlineService.getById(id);

        //then
        assertEquals(found.getId(), id);
    }

    @Test
    public void whenValidName_thenAirlineShouldBeFound() {
        // given
        String name = "UkraineAir";
        when(airline.getName()).thenReturn(name);
        when(airlineRepository.findByName(airline.getName()))
                .thenReturn(airline);
        // when
        Airline found = airlineService.searchByName(name);

        // then
        assertEquals(found.getName(), name);
    }

    @Test
    public void whenAddAircraft_thenShouldReturnAddedAircraft() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(aircraftService.save(airship)).thenReturn(airship);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);
        // when
        IAircraft added = airlineService.addAircraft(airline.getId(), airship);
        // then
        assertEquals(airship, added);
    }

    @Test
    public void whenGetAircraftList_thenReturnAllAircraftOfAirline() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        List<IAircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airship);
        aircraftList.add(airplane);
        when(airline.getAircraftList()).thenReturn(aircraftList);

        // when
        List<IAircraft> found = airlineService.getAircraftList(airline.getId());

        // then
        assertEquals(aircraftList, found);
    }

    @Test
    public void whenGetTotalPassengerCapacity_thenReturnTotalPassengerCapacity() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        int passengerCapacity = 200;
        when(airlineUtilService.getTotalPassengerCapacity(airline)).thenReturn(passengerCapacity);

        // when
        int foundPassengerCapacity = airlineService.getTotalPassengerCapacityById(airline.getId());

        // then
        assertEquals(passengerCapacity, foundPassengerCapacity);
    }


    @Test
    public void whenGetTotalCarryingCapacity_thenReturnTotalCarryingCapacity() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        int carryingCapacity = 20000;
        when(airlineUtilService.getTotalCarryingCapacity(airline)).thenReturn(carryingCapacity);

        // when
        int foundCarryingCapacity = airlineService.getTotalCarryingCapacityById(airline.getId());

        // then
        assertEquals(carryingCapacity, foundCarryingCapacity);
    }

    @Test
    public void whenGetFilteredByFuelConsumption_thenReturnFilteredList() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        List<IAircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airship);
        aircraftList.add(airplane);

        int minConsumption = 300, maxConsumption = 500;
        when(airlineUtilService
                .getFilteredByFuelConsumptionAircraftList(
                        airline, minConsumption, maxConsumption))
                .thenReturn(aircraftList);

        // when
        List<IAircraft> found = airlineService.getFilteredByFuelConsumptionAircraftList(airline.getId(), minConsumption, maxConsumption);

        // then
        assertEquals(aircraftList, found);
    }

    @Test
    public void whenGetSortedByFlightRange_thenReturnSortedList() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        List<IAircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airship);
        aircraftList.add(airplane);


        when(airlineUtilService
                .getSortedByFlightRangeAircraftList(airline))
                .thenReturn(aircraftList);

        // when
        List<IAircraft> found = airlineService.
                getSortedByFlightRangeAircraftList(airline.getId());

        // then
        assertEquals(aircraftList, found);
    }

    @Test
    public void whenGetFilteredByCapacityAndRange_thenReturnFilteredList() {
        // given
        when(airline.getId()).thenReturn(10L);
        when(airlineRepository.getOne(airline.getId())).thenReturn(airline);

        List<IAircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airship);
        aircraftList.add(airplane);

        int capacity = 300, range = 500;
        when(airlineUtilService
                .getFilteredByPassengerCapacityAndFlightRangeAircraftList(
                        airline, capacity, range))
                .thenReturn(aircraftList);

        // when
        List<IAircraft> found = airlineService
                .getFilteredByPassengerCapacityAndFlightRangeAircraftList(
                        airline.getId(), capacity, range);

        // then
        assertEquals(aircraftList, found);
    }

    @TestConfiguration
    static class AirlineServiceTestContextConfiguration {
        @Bean
        public IAirlineService airlineService(AirlineRepository airlineRepository, AircraftService aircraftService) {
            return new AirlineService(airlineRepository, aircraftService);
        }
    }

}