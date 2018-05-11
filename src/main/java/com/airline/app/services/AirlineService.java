package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import com.airline.app.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirlineService implements AirlineServiceInterface {
    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline getById(long id) {
        return airlineRepository.getOne(id);
    }

    @Override
    public Airline searchByName(String name) {
        return airlineRepository.findByName(name);
    }

    @Override
    @Transactional
    public Aircraft addAircraft(long id, Aircraft aircraft) {
        Airline airline = airlineRepository.getOne(id);
        airline.addAircraft(aircraft);
        airlineRepository.save(airline);
        return aircraft;
    }

    @Override
    public List<Aircraft> getAircraftList(long airlineId) {
        Airline airline = airlineRepository.getOne(airlineId);
        airlineRepository.save(airline);
        return airline.getAircraftList();
    }


    @Override
    public int getTotalPassengerCapacityById(long id) {
        Airline airline = airlineRepository.getOne(id);
        return AirlineUtilService.getTotalPassengerCapacity(airline);
    }

    @Override
    public int getTotalCarryingCapacityById(long id) {
        Airline airline = airlineRepository.getOne(id);
        return AirlineUtilService.getTotalCarryingCapacity(airline);
    }

    @Override
    public List<Aircraft> getSortedByFlightRangeAircraftList(long id) {
        Airline airline = airlineRepository.getOne(id);
        return AirlineUtilService.getSortedByFlightRangeAircraftList(airline);
    }

    @Override
    public List<Aircraft> getFilteredByFuelConsumptionAircraftList(long id, int min, int max) {
        Airline airline = airlineRepository.getOne(id);
        return AirlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, min, max);
    }

    @Override
    public List<Aircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(long id, int passengerCapacity, int flightRange) {
        Airline airline = airlineRepository.getOne(id);
        return AirlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, passengerCapacity, flightRange);
    }
}
