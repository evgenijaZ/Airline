package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import com.airline.app.entities.IAircraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAirlineService {

    Airline getById(long id);

    Airline searchByName(String name);

    IAircraft addAircraft(long id, Aircraft aircraft);

    List<IAircraft> getAircraftList(long airlineId);

    int getTotalPassengerCapacityById(long id);

    int getTotalCarryingCapacityById(long id);

    List<IAircraft> getSortedByFlightRangeAircraftList(long id);

    List<IAircraft> getFilteredByFuelConsumptionAircraftList(long id, int min, int max);

    List<IAircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(long id, int passengerCapacity, int flightRange);

    List<Airline> getAll();

    Page<Airline> findAllPageable(Pageable pageable);
}
