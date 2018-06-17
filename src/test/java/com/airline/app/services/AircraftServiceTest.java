package com.airline.app.services;

import com.airline.app.entities.Aircraft;
import com.airline.app.entities.Airplane;
import com.airline.app.entities.Airship;
import com.airline.app.entities.User;
import com.airline.app.repositories.AircraftRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AircraftServiceTest {

    @Autowired
    IAircraftService aircraftService;
    @MockBean
    AircraftRepository aircraftRepository;

    @Autowired
    Airship airship;
    @Autowired
    Airplane airplane;

    @Before
    public void setUp() {
        when(airship.getId()).thenReturn(100L);
        when(airplane.getModelName()).thenReturn("Boeing 737-300");
    }

    @Test
    public void whenValidName_thenAircraftShouldBeFound() {
        // given
        String modelName = "Boeing 737-300";
        when(aircraftRepository.findByModelName(airplane.getModelName()))
                .thenReturn(airplane);
        // when
        Aircraft found = aircraftService.getByModelName(modelName);

        // then
        assertEquals(found.getModelName(), modelName);
    }

    @Test
    public void whenValidId_thenAircraftShouldBeFound() {
        long id = 100;
        when(aircraftRepository.findById(airship.getId()))
                .thenReturn(airship);
        //when
        Aircraft found = aircraftService.get(id);

        //then
        assertEquals(found.getId(), id);
    }

    @Test
    public void whenSaveAircraft_thenShouldReturnAircraft() {
        when(aircraftRepository.save(airship))
                .thenReturn(airship);
        //when
        Aircraft found = aircraftService.save(airship);

        //then
        assertEquals(found, airship);
    }

    @Test
    public void whenGetAll_thenShouldReturnAircraftList() {
        //given
        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(airplane);
        aircraftList.add(airship);
        when(aircraftRepository.findAll())
                .thenReturn(aircraftList);
        //when
        List<Aircraft> foundList = aircraftService.getAll();

        //then
        assertEquals(aircraftList, foundList);
    }


    @TestConfiguration
    static class AircraftServiceTestContextConfiguration {
        @Bean
        public IAircraftService aircraftService(AircraftRepository aircraftRepository) {
            return new AircraftService(aircraftRepository);
        }

        @Bean
        public Airship airship() {
            return Mockito.mock(Airship.class);
        }

        @Bean
        public Airplane airplane() {
            return Mockito.mock(Airplane.class);
        }
    }

}