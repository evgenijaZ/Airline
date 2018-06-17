package com.airline.app.controllers;

import com.airline.app.domain.Pager;
import com.airline.app.entities.Aircraft;
import com.airline.app.entities.IAircraft;
import com.airline.app.services.AircraftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("aircraft")
public class AircraftController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 6;
    private static final int[] PAGE_SIZES = {6, 12, 20};

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public ModelAndView getAllPageable(@RequestParam("pageSize") Optional<Integer> pageSize,
                                       @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("aircraft");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Aircraft> aircraft = aircraftService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(aircraft.getTotalPages(), aircraft.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("aircraftList", aircraft);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("type", "all");
        return modelAndView;
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


        modelAndView.addObject("type", aircraft.getClass().getSimpleName());

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

    @GetMapping("/search")
    public ModelAndView getAircraftByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) return new ModelAndView("redirect:/aircraft");
        ModelAndView modelAndView = new ModelAndView("aircraft-search");
        List<Aircraft> aircraft = aircraftService.searchAllByName(name);
        modelAndView.addObject("type", "all");
        modelAndView.addObject("aircraftList", aircraft);
        return modelAndView;
    }

    @GetMapping("/type/{type}")
    public ModelAndView getAircraftByType(@PathVariable String type) {
        if (type == null || type.isEmpty()) return new ModelAndView("redirect:/aircraft");
        ModelAndView modelAndView = new ModelAndView("aircraft-search");
        List<Aircraft> aircraft = new ArrayList<>();
        switch (type) {
            case "airplane": {
                aircraft = aircraftService.getAllAirplanes();
                break;
            }
            case "airship": {
                aircraft = aircraftService.getAllAirships();
                break;
            }
            case "helicopter": {
                aircraft = aircraftService.getAllHelicopters();
                break;
            }
        }
        modelAndView.addObject("type", type);
        modelAndView.addObject("aircraftList", aircraft);
        return modelAndView;
    }
}
