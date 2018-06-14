package com.airline.app.controllers;

import com.airline.app.domain.Pager;
import com.airline.app.entities.Airline;
import com.airline.app.services.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airlines")
public class AirlineController {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 6;
    private static final int[] PAGE_SIZES = {6, 12, 20};

    private final IAirlineService airlineService;

    @Autowired
    public AirlineController(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/search")
    public ModelAndView getAirlineByName(@RequestParam String name){
        if(name==null || name.isEmpty()) return new ModelAndView("redirect:/airlines");
        ModelAndView modelAndView = new ModelAndView("airlines-search");
        List<Airline> airlines = airlineService.searchAllByName(name);
        modelAndView.addObject("airlineList", airlines);
        return modelAndView;
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

    @GetMapping
    public ModelAndView showAirlinesPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("airlines");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Airline> airlines = airlineService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(airlines.getTotalPages(), airlines.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("airlineList", airlines);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
