package com.airline.app.controllers;

import com.airline.app.entities.Aircraft;
import com.airline.app.services.AirlineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airlines/{id}/aircraft")
public class AirlineAircraftController {
    private final AirlineServiceInterface airlineService;

    @Autowired
    public AirlineAircraftController(AirlineServiceInterface airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public List<Aircraft> getAircraftList(@PathVariable("id") long id) {
        return airlineService.getAircraftList(id);
    }

    @GetMapping("/sorted-by-flight-range")
    public List<Aircraft> getSortedByFlightRange(@PathVariable("id") long id) {
        return airlineService.getSortedByFlightRangeAircraftList(id);
    }

    @GetMapping("/filtered-by-fuel-consumption")
    public List<Aircraft> getSortedByFlightRange(@PathVariable("id") long id, @RequestParam("min") int min, @RequestParam("max") int max) {
        return airlineService.getFilteredByFuelConsumptionAircraftList(id, min, max);
    }

    @GetMapping("/filtered-by-passenger-capacity-and-flight-range")
    public List<Aircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(@PathVariable("id") long id, @RequestParam("capacity") int passengerCapacity, @RequestParam("range") int flightRange) {
        return airlineService.getFilteredByPassengerCapacityAndFlightRangeAircraftList(id, passengerCapacity, flightRange);
    }
}
