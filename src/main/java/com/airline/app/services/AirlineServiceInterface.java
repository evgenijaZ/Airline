package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;

import java.util.List;

public interface AirlineServiceInterface {

    Airline getById(long id);

    Airline searchByName(String name);

    Aircraft addAircraft(long id, Aircraft aircraft);

    List<Aircraft> getAircraftList(long airlineId);

    int getTotalPassengerCapacityById(long id);

    int getTotalCarryingCapacityById(long id);

    List<Aircraft> getSortedByFlightRangeAircraftList(long id);

    List<Aircraft> getFilteredByFuelConsumptionAircraftList(long id, int min, int max);

    List<Aircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(long id, int passengerCapacity, int flightRange);
}
