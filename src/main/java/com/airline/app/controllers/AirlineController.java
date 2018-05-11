package com.airline.app.controllers;

import com.airline.app.entities.Airline;
import com.airline.app.services.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airlines")
public class AirlineController {
    private final IAirlineService airlineService;

    @Autowired
    public AirlineController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public Airline getAirlineByName(@RequestParam String name){
        return airlineService.searchByName(name);
    }
    @GetMapping("/{id}")
    public Airline getAirlineById(@PathVariable Integer id) {
        return airlineService.getById(id);
    }

    @GetMapping("/{id}/total-passenger-capacity")
    public int getTotalPassengerCapacity(@PathVariable("id") Long id) {
        return airlineService.getTotalPassengerCapacityById(id);
    }

    @GetMapping("/{id}/total-carrying-capacity")
    public int getTotalCarryingCapacity(@PathVariable("id") Long id) {
        return airlineService.getTotalCarryingCapacityById(id);
    }
}
