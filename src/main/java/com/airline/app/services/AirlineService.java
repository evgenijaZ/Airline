package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airline;
import com.airline.app.entities.IAircraft;
import com.airline.app.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirlineService implements IAirlineService {
    private final AirlineRepository airlineRepository;
    private final AircraftService aircraftService;
    final AirlineUtilService airlineUtilService;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository, AircraftService aircraftService, AirlineUtilService airlineUtilService) {
        this.airlineRepository = airlineRepository;
        this.aircraftService = aircraftService;
        this.airlineUtilService = airlineUtilService;
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
    public IAircraft addAircraft(long id, Aircraft aircraft) {
        Airline airline = airlineRepository.getOne(id);
        aircraft = aircraftService.save(aircraft);
        airline.addAircraft(aircraft);
        airlineRepository.save(airline);
        return aircraft;
    }

    @Override
    public List<IAircraft> getAircraftList(long airlineId) {
        Airline airline = airlineRepository.getOne(airlineId);
        //airlineRepository.saveAndFlush(airline);
        return airline.getAircraftList();
    }


    @Override
    public int getTotalPassengerCapacityById(long id) {
        Airline airline = airlineRepository.getOne(id);
        return airlineUtilService.getTotalPassengerCapacity(airline);
    }

    @Override
    public int getTotalCarryingCapacityById(long id) {
        Airline airline = airlineRepository.getOne(id);
        return airlineUtilService.getTotalCarryingCapacity(airline);
    }

    @Override
    public List<IAircraft> getSortedByFlightRangeAircraftList(long id) {
        Airline airline = airlineRepository.getOne(id);
        return airlineUtilService.getSortedByFlightRangeAircraftList(airline);
    }

    @Override
    public List<IAircraft> getFilteredByFuelConsumptionAircraftList(long id, int min, int max) {
        Airline airline = airlineRepository.getOne(id);
        return airlineUtilService.getFilteredByFuelConsumptionAircraftList(airline, min, max);
    }

    @Override
    public List<IAircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(long id, int passengerCapacity, int flightRange) {
        Airline airline = airlineRepository.getOne(id);
        return airlineUtilService.getFilteredByPassengerCapacityAndFlightRangeAircraftList(airline, passengerCapacity, flightRange);
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Page<Airline> findAllPageable(Pageable pageable) {
        return airlineRepository.findAll(pageable);
    }
}
