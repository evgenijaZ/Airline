package com.airline.app.controllers;

import com.airline.app.entities.AbstractAircraft;
import com.airline.app.entities.Aircraft;
import com.airline.app.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aircraft")
public class AircraftController {
    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftController(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping("/{id}")
    public Aircraft getById(@PathVariable("id") long id) {
        return aircraftRepository.getOne(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft add(@RequestBody AbstractAircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @PutMapping
    public Aircraft update(@RequestBody AbstractAircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        aircraftRepository.deleteById(id);
    }
}
