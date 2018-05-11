package com.airline.app.controllers;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.IAircraft;
import com.airline.app.services.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airlines/{id}/aircraft")
public class AirlineAircraftController {
    private final IAirlineService airlineService;

    @Autowired
    public AirlineAircraftController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public List<IAircraft> getAircraftList(@PathVariable("id") long id) {
        return airlineService.getAircraftList(id);
    }

    @GetMapping("/sorted-by-flight-range")
    public List<IAircraft> getSortedByFlightRange(@PathVariable("id") long id) {
        return airlineService.getSortedByFlightRangeAircraftList(id);
    }

    @GetMapping("/filtered-by-fuel-consumption")
    public List<IAircraft> getSortedByFlightRange(@PathVariable("id") long id, @RequestParam("min") int min, @RequestParam("max") int max) {
        return airlineService.getFilteredByFuelConsumptionAircraftList(id, min, max);
    }

    @GetMapping("/filtered-by-passenger-capacity-and-flight-range")
    public List<IAircraft> getFilteredByPassengerCapacityAndFlightRangeAircraftList(@PathVariable("id") long id, @RequestParam("capacity") int passengerCapacity, @RequestParam("range") int flightRange) {
        return airlineService.getFilteredByPassengerCapacityAndFlightRangeAircraftList(id, passengerCapacity, flightRange);
    }

    @PostMapping
    public IAircraft addAircraft(@PathVariable("id") long id, @RequestBody Aircraft aircraft){
        return airlineService.addAircraft(id, aircraft);
    }
}
