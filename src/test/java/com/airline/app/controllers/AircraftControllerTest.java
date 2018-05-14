package com.airline.app.controllers;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airplane;
import com.airline.app.entities.CargoPlane;
import com.airline.app.services.AircraftService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AircraftController.class)
@EnableWebMvc
public class AircraftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AircraftService aircraftService;

    @Test
    public void shouldReturnAircraftList() throws Exception {
        Aircraft airplane = new Airplane();
        airplane.setId(10L);

        List<Aircraft> aircraftList = Collections.singletonList(airplane);

        given(aircraftService.getAll()).willReturn(aircraftList);

        mockMvc.perform(get("/aircraft")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is((int) airplane.getId())));
    }

    @Test
    public void shouldReturnAircraftById() throws Exception {
        long id = 10;
        Aircraft airplane = new Airplane();
        airplane.setId(id);
        airplane.setModelName("Boeing");


        given(aircraftService.get(airplane.getId())).willReturn(airplane);

        mockMvc.perform(get("/aircraft/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelName", is(airplane.getModelName())));
    }

    @Test
    public void shouldSaveAndReturnAircraft() throws Exception {
        CargoPlane airplane = new CargoPlane();
        airplane.setModelName("Boeing 747-400F");
        airplane.setCarryingCapacity(396890);
        airplane.setFlightRange(8230);
        airplane.setFuelConsumption(1350.0f);
        airplane.setCruisingSpeed(980);
        airplane.setCargoWeight(300000);

        when(aircraftService.save(any(Aircraft.class))).thenReturn(airplane);

        String aircraftJsonRequest = "{\"modelName\":\"Boeing 747-400F\",\"passengerCapacity\":0,\"carryingCapacity\":396890,\"flightRange\":8230,\"fuelConsumption\":1350.0,\"cruisingSpeed\":980,\"cargoWeight\":300000,\"flying\":false}";
        mockMvc.perform(post("/aircraft")
                .contentType(MediaType.APPLICATION_JSON)
                .content(aircraftJsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.modelName", is(airplane.getModelName())))
                .andExpect(jsonPath("$.cargoWeight", is(airplane.getCargoWeight())));

    }
}
