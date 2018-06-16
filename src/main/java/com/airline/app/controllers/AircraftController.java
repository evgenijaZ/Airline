package com.airline.app.controllers;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.IAircraft;
import com.airline.app.services.AircraftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public ModelAndView getById(@PathVariable("id") long id) throws IOException {
        ModelAndView modelAndView = new ModelAndView("aircraft-page");
        Aircraft aircraft = aircraftService.get(id);

        modelAndView.addObject("modelName", aircraft.getModelName());
        modelAndView.addObject("id", aircraft.getId());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        Map props = mapper.convertValue(aircraft, Map.class);


        modelAndView.addObject("type",  aircraft.getClass().getSimpleName());

        Set<Map.Entry> entries = props.entrySet();

        Map<String, Object> result = new HashMap<>();

        entries.removeIf(entry -> entry.getKey().equals("id") || entry.getKey().equals("model_name"));
        entries.forEach(entry -> {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String keyValue = key.toString();
            keyValue = keyValue.replaceAll("_", " ");
            result.put(keyValue, value);
        });

        modelAndView.addObject("entries", result.entrySet());
        return modelAndView;
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
