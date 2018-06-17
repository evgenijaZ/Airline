package com.airline.app.controllers;

import com.airline.app.entities.Airline;
import com.airline.app.services.AirlineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    @WithMockUser
    public void shouldReturnTotalPassengerCapacity() throws Exception {
        // given
        long airlineId = 1;
        Airline airline = new Airline();
        airline.setId(airlineId);

        int passengerCapacity = 500;
        when(airlineService.getTotalPassengerCapacityById(airlineId)).thenReturn(passengerCapacity);

        // when, then
        mockMvc.perform(get("/airlines/{id}/total-passenger-capacity", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(passengerCapacity)));
    }

    @Test
    @WithMockUser
    public void shouldReturnTotalCarryingCapacity() throws Exception {
        // given
        long airlineId = 1;
        Airline airline = new Airline();
        airline.setId(airlineId);

        int carryingCapacity = 50000;
        when(airlineService.getTotalCarryingCapacityById(airlineId)).thenReturn(carryingCapacity);

        // when, then
        mockMvc.perform(get("/airlines/{id}/total-carrying-capacity", airlineId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(carryingCapacity)));
    }


    @Test
    @WithMockUser
    public void shouldReturnAirlineById() throws Exception {
        // given
        long id = 10;
        Airline airline = new Airline();
        airline.setId(id);
        airline.setName("UkraineAir");

        given(airlineService.getById(airline.getId())).willReturn(airline);

        // when, then
        mockMvc.perform(get("/airlines/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(airline.getName())));
    }
}