package com.airline.app.controllers;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.IAircraft;
import com.airline.app.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAll() {
        return aircraftService.getAll();
    }


    @GetMapping("/{id}")
    public IAircraft getById(@PathVariable("id") long id) {
        return aircraftService.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aircraft> add(@RequestBody Aircraft aircraft) {
        Aircraft created = aircraftService.save(aircraft);
        if (created != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping
    public IAircraft update(@RequestBody Aircraft aircraft) {
        return aircraftService.save(aircraft);
    }

    @DeleteMapping
    public void delete(@RequestParam long id) {
        aircraftService.delete(id);
    }
}
