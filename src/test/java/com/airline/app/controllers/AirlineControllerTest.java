package com.airline.app.controllers;

import com.airline.app.entities.Airline;
import com.airline.app.services.AirlineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AirlineController.class)
@EnableWebMvc
public class AirlineControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AirlineService airlineService;

    @Test
    public void shouldReturnTotalPassengerCapacity() throws Exception {
        long airlineId = 1;
        Airline airline = new Airline();
        airline.setId(airlineId);


        int passengerCapacity = 500;
        when(airlineService.getTotalPassengerCapacityById(airlineId)).thenReturn(passengerCapacity);

        mockMvc.perform(get("/airlines/{id}/total-passenger-capacity", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(passengerCapacity)));
    }

    @Test
    public void shouldReturnTotalCarryingCapacity() throws Exception {
        long airlineId = 1;
        Airline airline = new Airline();
        airline.setId(airlineId);


        int carryingCapacity = 50000;
        when(airlineService.getTotalCarryingCapacityById(airlineId)).thenReturn(carryingCapacity);

        mockMvc.perform(get("/airlines/{id}/total-carrying-capacity", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(carryingCapacity)));
    }


    @Test
    public void shouldReturnAirlineById() throws Exception {
        long id = 10;
        Airline airline = new Airline();
        airline.setId(id);
        airline.setName("UkraineAir");


        given(airlineService.getById(airline.getId())).willReturn(airline);

        mockMvc.perform(get("/airlines/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(airline.getName())));
    }
}