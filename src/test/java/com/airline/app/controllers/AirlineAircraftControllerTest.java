package com.airline.app.controllers;

import com.airline.app.entities.*;
import com.airline.app.repositories.AirlineRepository;
import com.airline.app.services.AirlineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AirlineAircraftController.class)
@EnableWebMvc
public class AirlineAircraftControllerTest {
    @MockBean
    AirlineService airlineService;
    @MockBean
    AirlineRepository airlineRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAircraftList() throws Exception {
        long airlineId = 1, aircraftId = 10;
        Airline airline = new Airline();
        airline.setId(airlineId);
        Aircraft airplane = new Airplane();
        airplane.setId(aircraftId);

        List<IAircraft> aircraftList = Collections.singletonList(airplane);

        when(airlineService.getAircraftList(airlineId)).thenReturn(aircraftList);

        mockMvc.perform(get("/airlines/{id}/aircraft", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is((int) aircraftId)));
    }

    @Test
    public void shouldReturnFilteredByFuelConsumptionAircraftList() throws Exception {
        long airlineId = 1, airplaneId = 10, helicopterId = 10;
        Airline airline = new Airline();
        airline.setId(airlineId);
        Aircraft airplane = new Airplane();
        airplane.setId(airplaneId);
        Helicopter helicopter = new Helicopter();
        helicopter.setId(helicopterId);

        List<IAircraft> aircraftList = Arrays.asList(new Aircraft[]{airplane, helicopter});

        int minConsumption = 300, maxConsumption = 500;
        when(airlineService.getFilteredByFuelConsumptionAircraftList(airlineId, minConsumption, maxConsumption)).thenReturn(aircraftList);

        mockMvc.perform(get("/airlines/{id}/aircraft/filtered-by-fuel-consumption?min=" + minConsumption + "&max=" + maxConsumption, airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is((int) airplaneId)))
                .andExpect(jsonPath("$[1].id", is((int) helicopterId)));
    }

    @Test
    public void shouldReturnFilteredByCapacityAndrangeAircraftList() throws Exception {
        long airlineId = 1, airplaneId = 10, helicopterId = 10;
        Airline airline = new Airline();
        airline.setId(airlineId);
        Aircraft airplane = new Airplane();
        airplane.setId(airplaneId);
        Helicopter helicopter = new Helicopter();
        helicopter.setId(helicopterId);

        List<IAircraft> aircraftList = Arrays.asList(new Aircraft[]{airplane, helicopter});

        int capacity = 300, range = 500;
        when(airlineService.getFilteredByPassengerCapacityAndFlightRangeAircraftList(airlineId, capacity, range)).thenReturn(aircraftList);

        mockMvc.perform(get("/airlines/{id}/aircraft/filtered-by-passenger-capacity-and-flight-range?capacity=" + capacity + "&range=" + range, airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is((int) airplaneId)))
                .andExpect(jsonPath("$[1].id", is((int) helicopterId)));
    }

    @Test
    public void shouldReturnSortedAircraftList() throws Exception {
        long airlineId = 1, airplaneId = 10, helicopterId = 10;
        Airline airline = new Airline();
        airline.setId(airlineId);
        Aircraft airplane = new Airplane();
        airplane.setId(airplaneId);
        Helicopter helicopter = new Helicopter();
        helicopter.setId(helicopterId);

        List<IAircraft> aircraftList = Arrays.asList(new Aircraft[]{airplane, helicopter});

        when(airlineService.getSortedByFlightRangeAircraftList(airlineId)).thenReturn(aircraftList);

        mockMvc.perform(get("/airlines/{id}/aircraft/sorted-by-flight-range", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is((int) airplaneId)))
                .andExpect(jsonPath("$[1].id", is((int) helicopterId)));
    }



}
